import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        int MOD = 1_000_000_009;
        
        int[][] dp = new int[100_001][2];
        
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;
        
        for(int i = 4; i <= 100000;i++){
            dp[i][0] = ((dp[i-1][1]%MOD + dp[i-2][1]%MOD)%MOD + dp[i-3][1]%MOD)%MOD;
            dp[i][1] = ((dp[i-1][0]%MOD + dp[i-2][0]%MOD)%MOD + dp[i-3][0]%MOD)%MOD;
        }
        
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            
            System.out.printf("%d %d\n", dp[n][1], dp[n][0]);
        }
    }
}