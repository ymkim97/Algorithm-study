import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] soldiers = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	soldiers[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N];
        
        Arrays.fill(dp, 1);
        
        int answer = 1;
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < i; j++) {
        		if (soldiers[j] > soldiers[i]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        			answer = Math.max(answer, dp[i]);
        		}
        	}
        }
        
        System.out.println(N - answer);
	}
}