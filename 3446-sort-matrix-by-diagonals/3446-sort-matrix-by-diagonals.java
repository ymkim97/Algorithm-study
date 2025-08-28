class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Down
        for (int i = 0; i < n; i++) {
            Integer[] tmp = new Integer[n - i];

            for (int j = 0; j < n - i; j++) {
                tmp[j] = grid[i + j][j];
            }

            Arrays.sort(tmp, Collections.reverseOrder());

            for (int j = 0; j < n - i; j++) {
                grid[i + j][j] = tmp[j];
            }
        }

        // Right
        for (int i = 1; i < n; i++) {
            Integer[] tmp = new Integer[n - i];

            for (int j = 0; j < n - i; j++) {
                tmp[j] = grid[j][i + j];
            }

            Arrays.sort(tmp);

            for (int j = 0; j < n - i; j++) {
                grid[j][i + j] = tmp[j];
            }
        }

        return grid;
    }
}