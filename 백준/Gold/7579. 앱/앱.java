import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int[] arrM = new int[N + 1];
        for (int i = 1; i <= N; i++) {
        	arrM[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        
        int[] arrC = new int[N + 1];
        for (int i = 1; i <= N; i++) {
        	arrC[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N + 1][10001];
        
        for (int i = 1; i <= N; i++) {
        	int mem = arrM[i];
        	int cost = arrC[i];
        	
        	for (int j = 0; j <= 10000; j++) {
        		if (j < cost) dp[i][j] = dp[i - 1][j];
        		else {
        			dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + mem);
        		}
        		
        	}
        }
        
        for (int i = 0; i < 10001; i++) {
        	if (dp[N][i] >= M) {
        		System.out.println(i);
        		break;
        	}
        }
	}
}