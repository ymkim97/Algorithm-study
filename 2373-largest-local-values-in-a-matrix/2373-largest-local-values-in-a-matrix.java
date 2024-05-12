class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                result[i][j] = getMax(grid, i + 1, j + 1);
            }
        }

        return result;
    }

    public int getMax(int[][] grid, int a, int b) {
        int max = 0;

        for (int i = a - 1; i < a + 2; i++) {
            for (int j = b - 1; j < b + 2; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }
 }