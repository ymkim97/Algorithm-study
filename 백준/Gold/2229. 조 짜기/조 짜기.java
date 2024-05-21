import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        
        dp[0] = 0;
        dp[1] = 0;
        int max = 0;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	
        	for (int j = i - 1; j >= 1; j--) {
        		max = Math.max(max, Math.abs(arr[i] - arr[j]) + dp[j - 1]);
        	}
        	
        	dp[i] = max;
        }
        
        System.out.println(dp[N]);
    }
}