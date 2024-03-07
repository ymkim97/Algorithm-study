import java.util.*;

class Solution {
    
    Set<String> sorted = new HashSet<>();
    
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        Map<String, List<Integer>> table = new HashMap<>();
        
        for (String in : info) {
            String[] each = in.split(" ");
            String[] lang = {"-", each[0]};
            String[] end = {"-", each[1]};
            String[] level = {"-", each[2]};
            String[] food = {"-", each[3]};
            int score = Integer.parseInt(each[4]);
            
            for (String a : lang) {
                for (String b : end) {
                    for (String c : level) {
                        for (String d : food) {
                            String key = a + b + c + d;
                            
                            List<Integer> tmp = table.getOrDefault(key, new ArrayList<>());
                            tmp.add(score);
                            table.put(key, tmp);
                        }
                    }
                }
            }
        }
        
        for (String q : query) {
            String[] each = q.replace(" and ", " ").split(" ");
            int targetScore = Integer.parseInt(each[4]);

            String key = each[0] + each[1] + each[2] + each[3];
            
            if (!table.containsKey(key)) {
                answer.add(0);
                continue;
            }
            
            List<Integer> scores = table.get(key);
            if (!sorted.contains(key)) {
                Collections.sort(scores);
                sorted.add(key);
            }
            
            int low = 0;
            int high = scores.size();
            
            while (low < high) {
                int mid = (low + high) / 2;
                
                if (scores.get(mid) >= targetScore) {
                    high = mid;
                }
                
                else {
                    low = mid + 1;
                }
            }
            
            answer.add(scores.size() - high);
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
}