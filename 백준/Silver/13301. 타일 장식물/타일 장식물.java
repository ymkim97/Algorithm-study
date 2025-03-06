import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        long[] dp = new long[N + 1];
        
        if (N == 1) {
        	System.out.println(4);
        	return;
        } else if (N == 2) {
        	System.out.println(6);
        	return;
        } 
        
        dp[1] = 4;
        dp[2] = 6;
        
        for (int i = 3; i <= N; i++) {
        	dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        System.out.println(dp[N]);
	}
}
