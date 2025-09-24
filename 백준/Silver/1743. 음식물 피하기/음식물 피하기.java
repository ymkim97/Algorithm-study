import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = 1;
        }

        boolean[][] visited = new boolean [N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, map, visited);
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int r, int c, int[][] map, boolean[][] visited) {
        int[] mx = {0, 0, 1, -1};
        int[] my = {1, -1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        int tmpCount = 0;

        visited[r][c] = true;
        q.offer(new int[] {r, c});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            tmpCount += 1;

            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];

                if (dx < 0 || dy < 0 || dx >= map.length || dy >= map[0].length || visited[dx][dy] || map[dx][dy] == 0) continue;

                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy});
            }
        }

        answer = Math.max(answer, tmpCount);
    }
}
