import java.io.*;
import java.util.*;

class Main {
    
    static int[][] map;
    static int M, N;
    static int[][] dp;
    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        dp = new int[M][N];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        
        dfs(0, 0);
        
        System.out.println(dp[0][0]);
    }
    
    public static void dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            dp[x][y] = 1;
            return;
        }
        
        if (dp[x][y] != -1) {
            return;
        }
        
        dp[x][y] = 0;
        
        for (int i = 0; i < 4; i++) {
            int dx = x + mx[i];
            int dy = y + my[i];
            
            if (dx < 0 || dy < 0 || dx >= M || dy >= N) continue;
            if (map[dx][dy] >= map[x][y]) continue;
            
            dfs(dx, dy);
            dp[x][y] += dp[dx][dy];
        }
    }
}