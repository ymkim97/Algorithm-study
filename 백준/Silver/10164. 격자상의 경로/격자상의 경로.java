import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N][M];

        int firstComb = 0;
        int a = 0, b = 0;
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		if (i == 0 || j == 0) {
        			dp[i][j] = 1;
        			continue;
        		}
        		
        		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        		if ((M * i) + j + 1 == K) {
        			firstComb = dp[i][j];
        			a = i;
        			b = j;
        		}
        	}
        }
        
        int[][] dp2 = new int[N][M];
        
        for (int i = a; i < N; i++) {
        	for (int j = b; j < M; j++) {
        		if (i == a || j == b) {
        			dp2[i][j] = 1;
        			continue;
        		}
        		
        		dp2[i][j] = dp2[i - 1][j] + dp2[i][j - 1];
        	}
        }
        
        System.out.println(K == 0 ? dp[N - 1][M - 1] : firstComb * dp2[N - 1][M - 1]);
	}
}