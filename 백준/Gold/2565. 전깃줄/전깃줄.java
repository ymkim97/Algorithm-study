import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] wires = new int[n][2];
        
        for (int i = 0; i < n; i++) { 
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	wires[i][0] = a;
        	wires[i][1] = b;
        }
        
        Arrays.sort(wires, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
        	int[] wire = wires[i];
        	
        	dp[i] = 1;

        	for (int j = 0; j < i; j++) {
        		if (wires[j][1] < wire[1]) dp[i] = Math.max(dp[i], dp[j] + 1);
        	}

        }
        
        System.out.println(n - Arrays.stream(dp).max().getAsInt());
	}
}
