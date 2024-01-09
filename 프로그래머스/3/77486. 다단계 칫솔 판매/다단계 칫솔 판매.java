import java.util.*;

class Solution {
    
    Map<String, String> parents = new HashMap<>();
    Map<String, Integer> profits = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            parents.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            calculate(seller[i], amount[i] * 100);
        }
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profits.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    public void calculate(String seller, int amount) {
        int tenPercent = amount / 10;
        profits.put(seller, profits.getOrDefault(seller, 0) + amount - tenPercent);
        
        if (tenPercent > 0 && parents.containsKey(seller)) {
            calculate(parents.get(seller), tenPercent);
        }
    }
}