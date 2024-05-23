import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int MOD = 1_000_000_009;
        
        int T = Integer.parseInt(br.readLine());
        
        long[][] dp = new long[100001][4];
        
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        
        for (int i = 4; i < 100001; i++) {
        	dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
        	dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
        	dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }
        
        for (int test = 0; test < T; test++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	System.out.println((dp[num][1] + dp[num][2] + dp[num][3]) % MOD);
        }
    }
}