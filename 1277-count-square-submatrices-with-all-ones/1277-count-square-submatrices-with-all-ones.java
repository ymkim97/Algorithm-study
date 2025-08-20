class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]) + 1, matrix[i - 1][j - 1] + 1);
                    answer += matrix[i][j];
                } else if (matrix[i][j] > 0) answer += 1;
            }
        }

        return answer;
    }
}