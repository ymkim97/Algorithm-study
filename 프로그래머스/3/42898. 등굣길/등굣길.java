class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        
        for (int[] puddle : puddles) {
            int x = puddle[1];
            int y = puddle[0];
            
            dp[x][y] = -1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1 || (i == 1 && j == 1)) { // 물에 잠기거나 0,0 pass
                    continue;
                }

                int up = dp[i - 1][j] != -1 ? dp[i - 1][j] : 0;
                int left = dp[i][j - 1] != -1 ? dp[i][j - 1] : 0;

                dp[i][j] = (up + left) % 1_000_000_007;
            }
        }
        
        return dp[n][m];
    }
}