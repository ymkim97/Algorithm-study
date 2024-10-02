import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = discount.length;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String dis = discount[i];
            
            if (i < 10) {
                map.put(dis, map.getOrDefault(dis, 0) + 1);
                if (i != 9) continue;
            }
            
            if (i > 9) {
                map.put(dis, map.getOrDefault(dis, 0) + 1);
                map.put(discount[i - 10], map.get(discount[i - 10]) - 1);
            }
            
            boolean flag = true;
            for (int j = 0; j < want.length; j++) {
                if (map.getOrDefault(want[j], 0) < number[j]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer += 1;
            
        }        
        
        return answer;
    }
}