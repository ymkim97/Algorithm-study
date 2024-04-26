import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] flight = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                flight[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][][] dp = new int[N][M][2]; // 0: up, 1: down
        
        dp[N - 1][0][0] = flight[N - 1][0];
        
        for (int i = N - 1; i >= 0; i--) {
            if (i != N - 1) {
                dp[i][0][0] = flight[i][0] + dp[i + 1][0][0];
            }
            
            for (int j = 1; j < M; j++) {
                if (i == N - 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + flight[i][j];
                }
                    
                else {
                    dp[i][j][0] = Math.max(flight[i][j] + dp[i + 1][j][0], flight[i][j] + dp[i][j - 1][0]);
                }
            }
        }
        
        dp[N - 1][M - 1][1] = flight[N - 1][M - 1];
        
        for (int i = N - 1; i >= 0; i--) {
            if (i != N - 1) {
                dp[i][M - 1][1] = flight[i][M - 1] + dp[i + 1][M - 1][1];
            }
            for (int j = M - 2; j >= 0; j--) {
                if (i == N - 1) {
                    dp[i][j][1] = dp[i][j + 1][1] + flight[i][j];
                } else {
                    dp[i][j][1] = Math.max(flight[i][j] + dp[i][j + 1][1], flight[i][j] + dp[i + 1][j][1]);
                }
            }
        }
        
        int max = -100_000_001;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, dp[i][j][0] + dp[i][j][1]);
            }
        }
        
        System.out.println(max);
    }
}