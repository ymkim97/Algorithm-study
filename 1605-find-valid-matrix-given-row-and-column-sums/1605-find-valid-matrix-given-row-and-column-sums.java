class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;

        int[][] answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rowSum[i] < colSum[j]) answer[i][j] = rowSum[i];
                else answer[i][j] = colSum[j];
                
                rowSum[i] -= answer[i][j];
                colSum[j] -= answer[i][j];
            }
        }

        return answer;
    }
}