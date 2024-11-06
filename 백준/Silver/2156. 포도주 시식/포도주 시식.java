import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] juice = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	juice[i] = Integer.parseInt(br.readLine());
        }
        
        if (n == 1) {
        	System.out.println(juice[1]);
        	return;
        }
        
        int[] dp = new int[n + 1];
        
        dp[1] = juice[1];
        dp[2] = juice[1] + juice[2];
        
        for (int i = 3; i <= n; i++) {
        	dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + juice[i], dp[i - 3] + juice[i - 1] + juice[i]));
        }
        
        System.out.println(Arrays.stream(dp).max().getAsInt());
	}
}