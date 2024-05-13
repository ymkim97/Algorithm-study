import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] stones = new int[N];
        int[] dp = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        
        dp[0] = 1;
        
        for (int i = 0; i < N - 1; i++) {
            if (dp[i] == 1) {
                for (int j = i + 1; j < N; j++) {
                    if (((j - i) * (1 + Math.abs(stones[i] - stones[j]))) <= K) dp[j] = 1;
                }
            }
        }
        
        System.out.println(dp[N - 1] == 1 ? "YES" : "NO");
    }
}