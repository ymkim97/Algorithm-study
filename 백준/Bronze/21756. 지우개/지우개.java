import java.io.*;
import java.util.*;

class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
        	System.out.println(1);
        	return;
        }
        
        int[] dp = new int[N + 1];
        
        dp[1] = 1;
        
        int tmp = 2;
        int cnt = 0;
        int maxCnt = 2;
        
        for (int i = 2; i <= N; i++) {
        	
        	if (cnt == maxCnt) {
        		cnt = 0;
        		maxCnt *= 2;
        		tmp = maxCnt;
        	}
        	
        	dp[i] = tmp;
        	cnt += 1;
        }
        
        System.out.println(dp[N]);
    }
}