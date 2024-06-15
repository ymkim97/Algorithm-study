import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        
        int[] cards = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
        	cards[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= i; j++) {
        		dp[i] = Math.min(dp[i], cards[j] + dp[i - j]);
        	}
        }
        
        System.out.println(dp[N]);
	}
}