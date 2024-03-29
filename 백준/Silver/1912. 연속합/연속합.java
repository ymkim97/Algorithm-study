import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (i == 0) {
                dp[0] = num;
            } else {
                dp[i] = Math.max(num, dp[i - 1] + num);
            }
        }
        
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}