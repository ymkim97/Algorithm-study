import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> types = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            String name = cloth[0];
            
            types.put(type, types.getOrDefault(type, 0) + 1);
        }
        
        for (int n : types.values()) {
            answer *= (n + 1);
        }
        
        return answer - 1;
    }
}