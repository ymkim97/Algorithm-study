import java.io.*;
import java.util.*;

class Main {
	
	static List<Integer>[] tree;
	static int[] dp;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
        	tree[i] = new ArrayList<>();
        }
        
        dp = new int[N];
        
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        
        for (int i = 1; i < N; i++) {
        	tree[Integer.parseInt(st.nextToken())].add(i);
        }
        
        System.out.println(dfs(0));        
    }
    
    public static int dfs(int cur) {
    	int cnt = 0;
    	int max = 0;
    	
    	Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
    	for(int next : tree[cur]) {
    		dp[next] = dfs(next);
    		pq.add(new int[] {next, dp[next]});
    	}
    	
    	while (!pq.isEmpty()) {
    		int[] node = pq.poll();
    		cnt += 1;
    		max = Math.max(max, node[1] + cnt);
    	}
    	
    	return max;
    }
}