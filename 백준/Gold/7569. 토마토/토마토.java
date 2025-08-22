import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] tomatoes = new int[N][M][H];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<Point> q = new LinkedList<>();

        int zeroCount = 0;

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomatoes[i][j][k] == 1) {
                        q.offer(new Point(i, j, k, true));
                    } else if (tomatoes[i][j][k] == 0) zeroCount += 1;
                }
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }
    
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        int[] mz = {1, -1};

        while (!q.isEmpty()) {
            Point p = q.poll();

            // 상하좌우
            for (int i = 0; i < 4; i++) {
                int dx = p.x + mx[i];
                int dy = p.y + my[i];

                if (dx < 0 || dy < 0 || dx >= N || dy >= M || tomatoes[dx][dy][p.z] != 0) continue;

                if (p.isfirst) {
                    tomatoes[dx][dy][p.z] = tomatoes[p.x][p.y][p.z];
                } else {
                    tomatoes[dx][dy][p.z] = tomatoes[p.x][p.y][p.z] + 1;
                }
                q.offer(new Point(dx, dy, p.z, false));
            }

            // 상자 위칸 아래칸
            for (int i = 0; i < 2; i++) {
                int dz = p.z + mz[i];

                if (dz < 0 || dz >= H || tomatoes[p.x][p.y][dz] != 0) continue;

                if (p.isfirst) {
                    tomatoes[p.x][p.y][dz] = tomatoes[p.x][p.y][p.z];
                } else {
                    tomatoes[p.x][p.y][dz] = tomatoes[p.x][p.y][p.z] + 1;
                }
                
                q.offer(new Point(p.x, p.y, dz, false));
            }
        }

        int answer = 0;

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomatoes[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    answer = Math.max(answer, tomatoes[i][j][k]);
                }
            }
        }

        System.out.println(answer);
    }

    static class Point {
        int x;
        int y;
        int z;
        boolean isfirst;

        public Point(int x, int y, int z, boolean isfirst) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.isfirst = isfirst;
        }
    }
}
