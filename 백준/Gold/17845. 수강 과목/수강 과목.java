import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] importance = new int[K + 1];
        int[] time = new int[K + 1];
        
        for (int i = 1; i <= K; i++) {
        	st = new StringTokenizer(br.readLine());
        	int I = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            
            importance[i] = I;
            time[i] = T;
        }
        
        int[][] dp = new int[K + 1][N + 1];
        
        for (int i = 1; i <= K; i++) {
        	for (int j = 1; j <= N; j++) {
        		if (j >= time[i]) {
        			dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time[i]] + importance[i]);
        		} else {
        			dp[i][j] = dp[i - 1][j];
        		}
        	}
        }
        
        System.out.println(dp[K][N]);
    }
}
