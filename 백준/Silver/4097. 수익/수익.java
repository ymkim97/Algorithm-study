import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            int[] money = new int[N];
            int[] dp = new int[N];
            
            for (int i = 0; i < N; i++) {
                money[i] = Integer.parseInt(br.readLine());
            }
            
            dp[0] = money[0];
            
            for (int i = 1; i < N; i++) {
                dp[i] = Math.max(money[i], money[i] + dp[i - 1]);
            }
            
            System.out.println(Arrays.stream(dp).max().getAsInt());
        }
    }
}