class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                flipRow(i, n, grid);
            }
        }

        for (int i = 0; i < n; i++) {
            int ones = 0;
            int zeros = 0;

            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 0) zeros += 1;
                else ones += 1;
            }

            if (zeros > ones) flipColumn(i, m, grid);
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) result += Math.pow(2, (n - 1 - j));

            }
        }

        return result;
    }

    public void flipRow(int r, int n, int[][] grid) {
        for (int i = 0; i < n; i++) {
            if (grid[r][i] == 0) grid[r][i] = 1;
            else grid[r][i] = 0;
        }
    }

    public void flipColumn(int c, int m, int[][] grid) {
        for (int i = 0; i < m; i++) {
            if (grid[i][c] == 0) grid[i][c] = 1;
            else grid[i][c] = 0;
        }
    }
}