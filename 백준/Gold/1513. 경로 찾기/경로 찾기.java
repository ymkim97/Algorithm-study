import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int MOD = 1_000_007;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N + 1][M + 1];
        int[][][][] dp = new int[N + 1][M + 1][C + 1][C + 1]; // x,y,현재까지 방문한 가장 큰 번호, 현재까지 방문한 오락실 수
        
        for (int i = 1; i <= C; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = i;
        }
        
        dp[1][1][map[1][1]][map[1][1] != 0 ? 1 : 0] = 1;
        
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {
                if (map[x][y] == 0) {
                    for (int c = 0; c <= C; c++) {
                        for (int m = 0; m <= C; m++) {
                            dp[x][y][m][c] = (dp[x][y][m][c] + dp[x - 1][y][m][c] + dp[x][y - 1][m][c]) % MOD;
                        }
                    }
                } else {
                    for (int c = 1; c <= C; c++) {
                        for (int m = 0; m < map[x][y]; m++) {
                            dp[x][y][map[x][y]][c] = (dp[x][y][map[x][y]][c] + dp[x - 1][y][m][c - 1] + dp[x][y - 1][m][c - 1]) % MOD;
                        }
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int c = 0; c <= C; c++) {
            int sum = 0;
            for (int m = 0; m <= C; m++) {
                sum = (sum + dp[N][M][m][c]) % MOD;
            }
            sb.append(sum).append(' ');
        }
        
        System.out.println(sb.toString());
    }
}
