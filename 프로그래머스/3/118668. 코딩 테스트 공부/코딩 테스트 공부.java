import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int[][] dp = new int[900][900];
        
        int alpMax = alp;
        int copMax = cop;
        
        for (int i = 0; i < problems.length; i++) {
            alpMax = Math.max(alpMax, problems[i][0]);
            copMax = Math.max(copMax, problems[i][1]);
        }
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;
        
        for (int i = alp; i <= alpMax; i++) {
            for (int j = cop; j <= copMax; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                for (int[] pr : problems) {
                    if (i >= pr[0] && j >= pr[1]) {
                        int nextAlp = Math.min(i + pr[2], alpMax);
                        int nextCop = Math.min(j + pr[3], copMax);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + pr[4]);
                    }
                }
            }
        }
        
        return dp[alpMax][copMax];
    }
}