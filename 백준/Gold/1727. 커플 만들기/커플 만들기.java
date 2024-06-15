import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] boys = new int[n + 1];
        int[] girls = new int[m + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= n; i++) {
        	boys[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= m; i++) {
        	girls[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(boys);
        Arrays.sort(girls);
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= m; j++) {
        		dp[i][j] = dp[i - 1][j - 1] + Math.abs(boys[i] - girls[j]);
        		
        		if (i > j) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
        		else if (j > i) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
        		
        	}
        }
        
        System.out.println(dp[n][m]);
	}
}