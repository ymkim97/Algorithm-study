import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] woks = new int[10001];
        woks[0] = 1;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= M; i++) {
        	woks[Integer.parseInt(st.nextToken())] += 1;
        }
        
        int[] dp = new int[N + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= N; i++) {
        	for (int j = 0; j <= i / 2; j++) {
        		if (j == i - j && woks[j] >= 2) dp[i] = 1;
        		else if (j != i - j && woks[j] > 0 && woks[i - j] > 0) dp[i] = 1;
        		else if (dp[j] != Integer.MAX_VALUE && dp[i - j] != Integer.MAX_VALUE) {
        			dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
        		}
        	}
        }
        
        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}
