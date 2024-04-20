class Solution {

    List<int[]> answer = new ArrayList<>();
    boolean[][] visited;
    int M, N;
    int[] mx = {1, -1, 0, 0};
    int[] my = {0, 0, 1, -1};

    public int[][] findFarmland(int[][] land) {
        M = land.length;
        N = land[0].length;

        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(i, j, land);
                }
            }
        }

        int[][] result = new int[answer.size()][4];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    public void bfs(int a, int b, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        visited[a][b] = true;
        q.offer(new int[] {a, b});
        int c = a;
        int d = b;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            c = Math.max(c, x);
            d = Math.max(d, y);

            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];

                if(dx < 0 || dy < 0 || dx >= M || dy >= N || visited[dx][dy] || land[dx][dy] == 0) continue;

                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy});
            }
        }

        answer.add(new int[] {a, b, c, d});
    }
}