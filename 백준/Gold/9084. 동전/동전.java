import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
        	int N = Integer.parseInt(br.readLine());
        	int[] coins = new int[N];
        	
        	st = new StringTokenizer(br.readLine());
        	
        	for (int i = 0; i < N; i++) {
        		coins[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int M = Integer.parseInt(br.readLine());
        	int[] dp = new int[M + 1];
        	dp[0] = 1;
        	
        	for (int i = 0; i < N; i++) {
        		int coin = coins[i];
        		
        		for (int j = 1; j <= M; j++) {
        			if (j < coin) continue;
        			
        			dp[j] = dp[j] + dp[j - coin];
        		}
        	}
        	
        	System.out.println(dp[M]);
        }
	}
}