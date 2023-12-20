import java.util.*;

class Solution {

    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n + 1];
        int answer = 0;
        
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int n = q.poll();
            
            for (int i = 0; i < computers[n - 1].length; i++) {
                if (computers[n - 1][i] == 1 && (i != n - 1) && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }
            }
        }
    }
}