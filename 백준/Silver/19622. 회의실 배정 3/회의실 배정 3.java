import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] tables = new int[N][3];
     
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cnt = Integer.parseInt(st.nextToken());
        	
        	tables[i][0] = start;
        	tables[i][1] = end;
        	tables[i][2] = cnt;
        }
        
        int[] dp = new int[N];
        
        if (N == 1) {
        	System.out.println(tables[0][2]);
        	return;
        }
        
        dp[0] = tables[0][2];
        dp[1] = Math.max(dp[0], tables[1][2]);
        
        for (int i = 2; i < N; i++) {
        	dp[i] = Math.max(dp[i - 1], dp[i - 2] + tables[i][2]);
        }
        
        System.out.println(dp[N - 1]);
	}
}