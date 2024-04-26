class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int a = 0; a < n; a++) {
                    if (a == j) continue;

                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][a]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", dp[i][j]);
            }
            System.out.println();
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, dp[n - 1][i]);
        }

        return answer;
    }
}