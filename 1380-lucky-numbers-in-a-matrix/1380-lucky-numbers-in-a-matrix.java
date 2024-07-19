class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int number = matrix[i][j];
                int min = number;
                int max = number;

                for (int a = 0; a < M; a++) {
                    min = Math.min(min, matrix[i][a]);
                }

                for (int a = 0; a < N; a++) {
                    max = Math.max(max, matrix[a][j]);
                }

                if (number == min && number == max) answer.add(number);
            }
        }

        return answer;
    }
}