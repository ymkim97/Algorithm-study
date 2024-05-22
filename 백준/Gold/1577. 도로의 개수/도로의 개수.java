import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        long [][] dp = new long[n+1][m+1];

        int[][] horizontal = new int[n][m+1];

        int[][] vertical = new int[n+1][m];
 
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
           
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
 
            if(b == d){
                horizontal[Math.min(a, c)][b] = 1;
            }else{
                vertical[a][Math.min(b, d)] = 1;
            }
 
        }
 
        for (int i = 1; i < n+1; i++) {
            if (horizontal[i-1][0] == 1) break;
 
            dp[i][0] = 1L;
 
        }
        for (int i = 1; i < m+1; i++) {
 
            if (vertical[0][i-1] == 1) break;
 
            dp[0][i] = 1;
        }
 
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
 
                if (horizontal[i-1][j] == 1) {
                    dp[i][j] -= dp[i-1][j];
                }
 

                if (vertical[i][j-1] == 1) {
                    dp[i][j] -= dp[i][j-1];
                }
            }
        }
        System.out.println(dp[n][m]);
 
    }
}