class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        boolean[][] visited = new boolean[m][n];
        boolean[][] isWall = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>(); // 0: x, 1: y, 2: isForward, 3: dir

        for (int[] g : guards) {
            visited[g[0]][g[1]] = true;
            q.offer(new int[] {g[0], g[1], 0, -1});
        }

        for (int[] w : walls) {
            visited[w[0]][w[1]] = true;
            isWall[w[0]][w[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int isForward = now[2];
            int dir = now[3];

            if (isForward == 0) { // Guard
                for (int i = 0; i < 4; i++) {
                    int dx = x + mx[i];
                    int dy = y + my[i];

                    if (dx < 0 || dy < 0 || dx >= m || dy >= n || isWall[dx][dy]) continue;

                    visited[dx][dy] = true;
                    q.offer(new int[] {dx, dy, 1, i});
                }
            } else {
                int dx = x + mx[dir];
                int dy = y + my[dir];

                if (dx < 0 || dy < 0 || dx >= m || dy >= n || isWall[dx][dy]) continue;

                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy, 1, dir});
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) answer += 1;
            }
        }
        return answer;
    }
}