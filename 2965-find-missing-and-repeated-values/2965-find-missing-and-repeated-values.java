class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] numbers = new int[n * n + 1];

        int repeat = 0;
        int missing = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (numbers[grid[i][j]] == 1) repeat = grid[i][j];
                numbers[grid[i][j]] = 1;
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (numbers[i] == 0) {
                missing = i;
                break;
            }
        }

        return new int[] {repeat, missing};
    }
}