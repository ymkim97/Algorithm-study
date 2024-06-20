import java.util.*;
import java.io.*;

class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N];
        
        for (int i = 1; i < N; i++) {
        	if (arr[i] < arr[i - 1]) dp[i] = dp[i - 1] + 1;
        	else dp[i] = dp[i - 1];
        }
        
        int Q = Integer.parseInt(br.readLine());
        
        for (int question = 0; question < Q; question++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken()) - 1;
        	int b = Integer.parseInt(st.nextToken()) - 1;
        	
        	sb.append(dp[b] - dp[a]).append("\n");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
	}
}