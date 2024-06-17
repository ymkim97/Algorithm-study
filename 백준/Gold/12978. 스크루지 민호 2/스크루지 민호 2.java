import java.util.*;
import java.io.*;

class Main {
	
	static int N;
	static List<Integer>[] map;
	static int[][] dp;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        N = Integer.parseInt(br.readLine());
        
        map = new ArrayList[N + 1];
        dp = new int[N + 1][2]; // 0: No, 1: Yes
        visited = new boolean[N + 1];
        
        for (int i = 0; i < N - 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (map[a] == null) map[a] = new ArrayList<>();
        	if (map[b] == null) map[b] = new ArrayList<>();
        	
        	map[a].add(b);
        	map[b].add(a);
        }
        
        dfs(1);
        
        System.out.println(Math.min(dp[1][1], dp[1][0]));
	}
	
	public static void dfs(int idx) {
		visited[idx] = true;
		dp[idx][1] = 1;
		
		for (int child : map[idx]) {
			if (visited[child]) continue;
			
			dfs(child);
			
			dp[idx][1] += Math.min(dp[child][1], dp[child][0]);
			dp[idx][0] += dp[child][1];
		}
	}
}