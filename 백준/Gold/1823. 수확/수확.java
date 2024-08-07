import java.util.*;
import java.io.*;

class Main {

	static int N;
	static int arr[];
	static int dp[][];
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        dp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	int t = Integer.parseInt(br.readLine());
        	
        	arr[i] = t;
        }
        
        System.out.println(calculate(0, N - 1, 1));
	}
	
	public static int calculate(int left, int right, int cnt) {
		if (left > right) return 0;
		
		if (dp[left][right] != 0) return dp[left][right];
		
		dp[left][right] = Math.max(calculate(left + 1, right, cnt + 1) + arr[left] * cnt, calculate(left, right - 1, cnt + 1) + arr[right] * cnt);
		
		return dp[left][right];
	}
}