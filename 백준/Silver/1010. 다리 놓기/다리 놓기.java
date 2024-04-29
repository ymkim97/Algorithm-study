import java.io.*;
import java.util.*;

class Main {
    
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            System.out.println(comb(M, N));
        }
    }
    
    public static int comb (int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];
        
        else if (n == r || r == 0) return dp[n][r] = 1;
        
        else return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}