import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		
		
		if (N == 1) {
			System.out.println(3);
			return;
		}
		
		dp[1] = 3;
		dp[2] = 7;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 2] + 2 * dp[i - 1]) % 9901;
		}
		
		System.out.println(dp[N]);
	}
}
