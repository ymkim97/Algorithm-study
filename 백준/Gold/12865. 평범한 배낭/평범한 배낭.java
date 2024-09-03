import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt((st.nextToken()));
        
        Thing[] arr = new Thing[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int W = Integer.parseInt(st.nextToken());
        	int V = Integer.parseInt(st.nextToken());
        	
        	arr[i] = new Thing(W, V);
        }
        
        int[][] dp =  new int[N + 1][K + 1];
        
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= K; j++) {
        		if (arr[i].w > j) dp[i][j] = dp[i - 1][j];
        		else dp[i][j] = Math.max(dp[i - 1][j], arr[i].v + dp[i - 1][j - arr[i].w]);
        	}
        }
        
        System.out.println(dp[N][K]);
	}
	
	static class Thing {
		int w;
		int v;
		
		public Thing(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}