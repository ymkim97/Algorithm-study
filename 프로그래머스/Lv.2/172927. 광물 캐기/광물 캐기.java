import java.util.*;

class Solution {
    
    Map<String, Integer>[] bag;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int picksSum = 0;
        for (int pick : picks) {
            picksSum += pick;
        }
        
        if (picksSum * 5 < minerals.length) {
            minerals = Arrays.copyOf(minerals, picksSum * 5);
        }
        
        bag = new HashMap[(minerals.length / 5) + (minerals.length % 5 == 0 ? 0 : 1)];
        
        for (int i = 0; i < minerals.length; i++) {
            if (i % 5 == 0) {
                bag[i / 5] = new HashMap<>();
            }
            
            Map<String, Integer> each = bag[i / 5];
            
            each.put(minerals[i], each.getOrDefault(minerals[i], 0) + 1);
        }
        
        Arrays.sort(bag, (o1, o2) -> {
            
            if (o1.getOrDefault("diamond", 0) == o2.getOrDefault("diamond", 0)) {
                if (o1.getOrDefault("iron", 0) == o2.getOrDefault("iron", 0)) {
                    return o2.getOrDefault("stone", 0) - o1.getOrDefault("stone", 0);
                }
                
                else {
                    return o2.getOrDefault("iron", 0) - o1.getOrDefault("iron", 0);
                }
            }
            
            else {
                return o2.getOrDefault("diamond", 0) - o1.getOrDefault("diamond", 0);
            }
        });
        
        int bagIdx = 0;
        
        for (int i = 0; i < 3; i++) {
            
            while (picks[i] > 0 && bagIdx != bag.length) {
                
                Map<String, Integer> each = bag[bagIdx];
                
                int dia = each.getOrDefault("diamond", 0);
                int iron = each.getOrDefault("iron", 0);
                int stone = each.getOrDefault("stone", 0);
                
                if (i == 0) { // 다이아몬드 곡괭이
                    answer += dia + iron + stone;
                }
                
                else if (i == 1) {  // 철 곡괭이
                    answer += 5 * dia + iron + stone;
                }
                
                else if (i == 2) {  // 돌 곡괭이
                    answer += 25 * dia + 5 * iron + stone;                    
                }
                
                picks[i] -= 1;
                bagIdx += 1;
            }
        }
        
        return answer;
    }
}