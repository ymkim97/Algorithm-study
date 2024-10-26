import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i ; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}
