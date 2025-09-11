import java.util.*;

class Solution {
    
    int[] answer = new int[2];
    int[] discount = new int[] {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        bruteforce(new ArrayList<>(), users, emoticons);
        
        return answer;
    }
    
    private void bruteforce(List<Integer> discountToUse, int[][] users, int[] emoticons) {
        if (discountToUse.size() == emoticons.length) {
            int[] discountedEmoticons = new int[emoticons.length];
            
            for (int i = 0; i < emoticons.length; i++) {
                discountedEmoticons[i] = emoticons[i] * (100 - discountToUse.get(i)) / 100;
            }
            
            int[] temp = new int[2];
            
            for (int[] user : users) {
                int minDiscount = user[0];
                int thresholdForSub = user[1];
                int payed = 0;
                
                for (int i = 0; i < discountedEmoticons.length; i++) {
                    if (minDiscount <= discountToUse.get(i)) {
                        payed += discountedEmoticons[i];
                    }
                }
                
                if (payed >= thresholdForSub) temp[0] += 1;
                else temp[1] += payed;
            }
            
            if (temp[0] > answer[0] || (temp[0] == answer[0] && temp[1] > answer[1])) {
                answer = temp;
            }
            
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            discountToUse.add(discount[i]);
            bruteforce(discountToUse, users, emoticons);
            discountToUse.remove(discountToUse.size() - 1);
        }
    }
}