import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[15][15]; // 0: 층, 1: 호
		
		for (int i = 1; i <= 14; i++) {
			dp[0][i] = i;
		}
		
		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				dp[i][j] = dp[i][j -1] + dp[i - 1][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			sb.append(dp[k][n]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
