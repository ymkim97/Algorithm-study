import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 1;
        int sum = arr[left];

        long[] dp = new long[N + 1];

        while (right <= N) {
        	
        	if (sum >= K) {
        		
        		while (sum >= K) {
        			dp[right] = Math.max(dp[right], dp[left] + sum - K);
        			sum -= arr[left];
        			left += 1;
        		}
        	}
        	
        	else {
        		dp[right] = Math.max(dp[right], dp[right - 1]);
        		
        		if (right == N) break;
        		
        		sum += arr[right];
        		right += 1;
        	}
        }
        
        System.out.println(dp[N]);
	}
}