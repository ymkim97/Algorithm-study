import java.util.*;

class Solution {
    
    int answer = Integer.MAX_VALUE;
    int n;
    List<Integer>[] tree;
    
    public int solution(int n, int[][] wires) {
        tree = new ArrayList[n + 1];
        this.n = n;
        
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            bfs(1, a, b);
        }
        
        return answer;
    }
    
    public void bfs(int start, int a, int b) {
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            count += 1;
            
            for (int child : tree[now]) {
                if ((a == now && b == child) || (a == child && b == now)) continue;
                
                if (!visited[child]) {
                    visited[child] = true;
                    q.offer(child);
                }
            }
        }
        
        int other = n - count;
        
        answer = Math.min(answer, Math.abs(other - count));
    }
}