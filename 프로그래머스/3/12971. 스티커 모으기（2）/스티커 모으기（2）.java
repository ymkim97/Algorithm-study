import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length == 1) {
            return sticker[0];    
        }
        
        int[] dp1 = Arrays.copyOfRange(sticker, 0, sticker.length - 1);
        int[] dp2 = Arrays.copyOfRange(sticker, 1, sticker.length);
        
        for (int i = 1; i < dp1.length; i++) {
            if (i == 1) {
                dp1[i] = Math.max(dp1[i], dp1[i - 1]);
                continue;
            }
            
            dp1[i] = Math.max(dp1[i - 1], dp1[i] + dp1[i - 2]);
        }
        
        for (int i = 1; i < dp2.length; i++) {
            if (i == 1) {
                dp2[i] = Math.max(dp2[i], dp2[i - 1]);
                continue;
            }
            
            dp2[i] = Math.max(dp2[i - 1], dp2[i] + dp2[i - 2]);
        }

        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}