import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[][] mv = {{1, -1}, {1, 0}, {1, 1}};
    static int[][] map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < M; i++) {
            dfs(0, i, -1, map[0][i]);
        }
        
        System.out.println(answer);
    }
    
    public static void dfs(int x, int y, int dir, int sum) {
        if (x == N - 1) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (dir == i) continue;
            
            int dx = x + mv[i][0];
            int dy = y + mv[i][1];
            
            if (dx < 0 || dy < 0 || dx >= N || dy >= M) continue;
            
            dfs(dx, dy, i, sum + map[dx][dy]);
        }
    }
}