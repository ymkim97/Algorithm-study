import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();

        while (true) {
        	int answer = 0;
        	
        	st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	if (N == 0 && M == 0) break;
        	
        	int[][] arr = new int[N][M];
        	
        	for (int i = 0; i < N; i++) { // arr input
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < M; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int[][] dp = new int[N][M];
        	
        	for (int i = 0; i < N; i++) { // first col search
        		answer = Math.max(answer, arr[i][0]);
        		
        		if (arr[i][0] == 0) dp[i][0] = 0;
        		else dp[i][0] = 1;
        	}
        	
        	for (int i = 0; i < M; i++) { // first row search
        		answer = Math.max(answer, arr[0][i]);
        		
        		if (arr[0][i] == 0) dp[0][i] = 0;
        		else dp[0][i] = 1;
        	}
        	
        	for (int i = 1; i < N; i++) {
        		for (int j = 1; j < M; j++) {
        			if (arr[i][j] == 1) {
        				if (arr[i][j - 1] == 1 && arr[i - 1][j] == 1 && arr[i - 1][j - 1] == 1) dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
        				else dp[i][j] = 1;
        			} else dp[i][j] = 0;
        			
        			answer = Math.max(answer, dp[i][j]);
        		}
        	}
        	
        	sb.append(answer).append("\n");
        }
        
        System.out.println(sb);
	}
}