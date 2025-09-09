import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
    
        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> sentCount = new HashMap<>();
        Map<String, Integer> receivedCount = new HashMap<>();
        
        for (String f : friends) {
            map.put(f, new HashMap<>());
        }
        
        for (String gift : gifts) {
            String[] g = gift.split(" ");
            String from = g[0];
            String to = g[1];
            
            Map<String, Integer> giftCount = map.getOrDefault(from, new HashMap<>());
            giftCount.put(to, giftCount.getOrDefault(to, 0) + 1);
            
            sentCount.put(from, sentCount.getOrDefault(from, 0) + 1);
            receivedCount.put(to, receivedCount.getOrDefault(to, 0) + 1);
        }
        
        Map<String, Integer> giftsToGet = new HashMap<>();
        
        for (String f : friends) {
            giftsToGet.put(f, 0);
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String a = friends[i];
                String b = friends[j];
                
                int aToB = map.get(a).getOrDefault(b, 0);
                int bToA = map.get(b).getOrDefault(a, 0);
                
                // 기록이 없거나 수가 같다면
                if (aToB == bToA) {
                    int aIndex = sentCount.getOrDefault(a, 0) - receivedCount.getOrDefault(a, 0);
                    int bIndex = sentCount.getOrDefault(b, 0) - receivedCount.getOrDefault(b, 0);
                    
                    if (aIndex == bIndex) continue;
                    
                    if (aIndex > bIndex) {
                        giftsToGet.put(a, giftsToGet.get(a) + 1);
                    } else {
                        giftsToGet.put(b, giftsToGet.get(b) + 1);
                    }
                } else { // 기록이 있고 수가 다르다면
                    if (aToB > bToA) giftsToGet.put(a, giftsToGet.get(a) + 1);
                    else giftsToGet.put(b, giftsToGet.get(b) + 1);
                }
            }
        }
        
        for (String key : giftsToGet.keySet()) {
            answer = Math.max(answer, giftsToGet.get(key));
        }
        
        return answer;
    }
}