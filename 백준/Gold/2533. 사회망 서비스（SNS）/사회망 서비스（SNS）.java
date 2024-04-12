import java.io.*;
import java.util.*;

class Main {
    
    static int[][] dp;
    static boolean[] visited;
    static List<Integer>[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (tree[a] == null) tree[a] = new ArrayList<>();
            if (tree[b] == null) tree[b] = new ArrayList<>();
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        
        dfs(1);
        
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    
    public static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 1;
        
        for (int next : tree[node]) {
            if (visited[next]) continue;
            
            dfs(next);
            
            dp[node][1] += dp[next][0];
            dp[node][0] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}