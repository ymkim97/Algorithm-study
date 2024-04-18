class Solution {

    int answer = 0;
    int m, n;
    boolean[][] visited;
    int[] mx = {0, 0, 1, -1};
    int[] my = {1, -1, 0, 0};

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    System.out.println("123");
                    bfs(i, j, grid);
                }
            }
        }

        return answer;
    }

    public void bfs(int a, int b, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        visited[a][b] = true;
        q.offer(new int[] {a, b});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];

                if (dx < 0 || dy < 0 || dx >= m || dy >= n || grid[dx][dy] == 0) {
                    answer += 1;
                    continue;
                }

                if (visited[dx][dy]) continue;

                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy});
            }
        }
    }
}