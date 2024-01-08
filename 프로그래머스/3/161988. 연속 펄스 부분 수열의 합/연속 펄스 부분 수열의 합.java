import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int[] pulse = new int[] {1, -1};
        int[] firstPulse = new int[sequence.length];
        int[] secondPulse = new int[sequence.length];
        
        for (int i = 0; i < sequence.length; i++) {
            firstPulse[i] = sequence[i] * pulse[i % 2];
            secondPulse[i] = sequence[i] * pulse[(i + 1) % 2];
        }

        long answer = Math.max(getMaxSum(firstPulse), getMaxSum(secondPulse));
        
        return answer;
    }
    
    public long getMaxSum(int[] seq) {
        long[] dp = new long[seq.length];
        
        for (int i = 0; i < seq.length; i++) {
            if (i == 0) {
                dp[i] = seq[i];
                continue;
            }
            
            dp[i] = Math.max(seq[i], seq[i] + dp[i - 1]);
        }
        
        return Arrays.stream(dp).max().getAsLong();
    }
}