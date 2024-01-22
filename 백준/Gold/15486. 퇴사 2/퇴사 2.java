import java.io.*;
import java.util.*;

class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N + 2][2];
        int[] dp = new int[N + 2];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            
            table[i][0] = T;
            table[i][1] = P;
        }
        
        int max = -1;
        
        for (int i = 1; i <= N + 1; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
            
            int next = i + table[i][0];
            if (next < N + 2) {
                dp[next] = Math.max(dp[next], max + table[i][1]);
            }
        }
        
        System.out.println(dp[N + 1]);
    }
}