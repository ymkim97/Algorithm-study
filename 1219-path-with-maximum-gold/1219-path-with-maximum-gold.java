import java.util.*;

class Solution {

    int m, n;
    int maxGold = 0;
    int[] mx = {0, 0, -1, 1};
    int[] my = {-1, 1, 0, 0};

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[m][n];
                    dfs(i, j, grid, visited, 0);
                }
            }
        }

        return maxGold;
    }

    public void dfs(int x, int y, int[][] grid, boolean[][] visited, int currGold) {
        visited[x][y] = true;
        currGold += grid[x][y];
        maxGold = Math.max(maxGold, currGold);

        for (int i = 0; i < 4; i++) {
            int dx = x + mx[i];
            int dy = y + my[i];

            if (dx >= 0 && dx < m && dy >= 0 && dy < n && !visited[dx][dy] && grid[dx][dy] != 0) {
                dfs(dx, dy, grid, visited, currGold);
            }
        }

        visited[x][y] = false;
    }
}
