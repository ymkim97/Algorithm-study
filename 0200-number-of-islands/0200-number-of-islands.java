class Solution {

    int[] mx = {1, -1, 0, 0};
    int[] my = {0, 0, 1, -1};
    boolean[][] visited;
    int M, N;
    int answer = 0;

    public int numIslands(char[][] grid) {
        M = grid.length;
        N = grid[0].length;

        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid[i][j] == '1') bfs(i, j, grid);
            }
        }

        return answer;
    }

    public void bfs(int a, int b, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];

                if (dx < 0 || dy < 0 || dx >= M || dy >= N || visited[dx][dy] || grid[dx][dy] == '0') continue;

                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy});
            }
        }

        answer += 1;
    }
}