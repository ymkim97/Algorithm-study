class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long answer = 0;
        int negativeCnt = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer += Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) negativeCnt += 1;
            }
        }

        if (negativeCnt % 2 == 0) return answer;

        return answer - min * 2;
    }
}