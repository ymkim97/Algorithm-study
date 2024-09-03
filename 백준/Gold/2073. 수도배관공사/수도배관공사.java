import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        st = new StringTokenizer(br.readLine());
        
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[D + 1];
        
        dp[0] = Integer.MAX_VALUE;
        
        for (int i = 0; i < P; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int L = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	
        	for (int j = D; j >= L; j--) {
        		dp[j] = Math.max(dp[j], Math.min(C, dp[j - L]));
        	}
        }
        
        System.out.println(dp[D]);
	}
}