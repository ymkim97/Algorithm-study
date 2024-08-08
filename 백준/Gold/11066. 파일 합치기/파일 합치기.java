import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
        	int K = Integer.parseInt(br.readLine());
        	int[] novel = new int[K + 1];
        	int[] sum = new int[K + 1];
        	int[][] dp = new int[K + 1][K + 1];
        	
        	st = new StringTokenizer(br.readLine());
        	
        	for (int i = 1; i <= K; i++) {
        		novel[i] = Integer.parseInt(st.nextToken());
        		
        		sum[i] = sum[i - 1] + novel[i];
        	}
        	
        	for (int n = 1; n <= K; n++) {
        		for (int from = 1; from + n <= K; from++) {
        			int to = from + n;
        			dp[from][to] = Integer.MAX_VALUE;
        			for (int mid = from; mid < to; mid++) {
        				dp[from][to] = Math.min(dp[from][to], dp[from][mid] + dp[mid + 1][to] + sum[to] - sum[from - 1]);
        			}
        		}
        	}
        	
        	System.out.println(dp[1][K]);
        }
	}
}