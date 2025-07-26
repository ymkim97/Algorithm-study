import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[] rest = new boolean[N + 1];
        if (M > 0) st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < M; i++) {
        	rest[Integer.parseInt(st.nextToken())] = true;
        }
        
        int[][] dp = new int[N + 1][N + 1];
        
        for (int i = 0; i <= N; i++) {
        	Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        System.out.println(dfs(1, 0, rest, dp, N));
    }
    
    private static int dfs(int day, int coupon, boolean[] rest, int[][] dp, int N) {
    	if(day > N) return 0;
    	
    	if (dp[day][coupon] != Integer.MAX_VALUE) return dp[day][coupon];
    	
    	if (rest[day]) {
    		dp[day][coupon] = dfs(day + 1, coupon, rest, dp, N);
    		return dp[day][coupon];
    	}
    	
    	dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 1, coupon, rest, dp, N) + 10_000);
    	dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 3, coupon + 1, rest, dp, N) + 25_000);
    	dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 5, coupon + 2, rest, dp, N) + 37_000);
    	
    	if (coupon >= 3) dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 1, coupon - 3, rest, dp, N));
    	
    	return dp[day][coupon];
    }
}
