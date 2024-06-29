import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        long[][] dp = new long[65][10];
        
        for (int i = 0; i <= 9; i++) {
        	dp[1][i] = 1;
        }
        
        for (int i = 2; i <= 64; i++) {
        	for (int j = 0; j <= 9; j++) {
        		for (int k = j; k <= 9; k++) {
        			dp[i][j] += dp[i - 1][k];
        		}
        	}
        }
        
        for (int test = 0; test < T; test++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	long answer = 0;
        	
        	for (int i = 0; i <= 9; i++) {
        		answer += dp[n][i];
        	}
        	
        	System.out.println(answer);
        }
	}
}