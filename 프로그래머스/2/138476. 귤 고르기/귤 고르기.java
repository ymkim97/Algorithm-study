import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int t: tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> keys = new LinkedList<>(map.keySet());
        
        Collections.sort(keys, (a, b) -> map.get(b) - map.get(a));
        
        int answer = 0;
        int current = 0;
        
        for (int i = 0; i < keys.size(); i++) {
            answer += 1;
            current += map.get(keys.get(i));
            
            if (current >= k) break;
        }
        
        return answer;
    }
}