class Solution {

    public long gridGame(int[][] grid) {
        long answer = Long.MAX_VALUE;
        int n = grid[0].length;
        long topSum = Arrays.stream(grid[0]).asLongStream().sum();
        long bottomSum = 0;

        for (int i = 0; i < n; i++) {
            topSum -= grid[0][i];
            answer = Math.min(answer, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
        }

        return answer;
    }
}
