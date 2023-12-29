import java.util.*;

class Solution {
    
    boolean[][] graph;
    int[] visited;
    
    public int solution(int n, int[][] edge) {
        graph = new boolean[n + 1][n + 1];
        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        
        for (int[] vertex : edge) { // 그래프 생성
            int a = vertex[0];
            int b = vertex[1];
            
            graph[a][b] = true;
            graph[b][a] = true;
        }
        
        bfs(1);
        
        int max = 0;
        int answer = 0;
        for (int visitCnt : visited) {
            if (visitCnt > max) {
                max = visitCnt;
                answer = 1;
            }
            
            else if (visitCnt == max) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = 0;
        
        while (!q.isEmpty()) {
            int num = q.poll();
            
            for (int i = 1; i < graph[num].length; i++) {
                if (graph[num][i] == true && visited[i] == -1) {
                    visited[i] = visited[num] + 1;
                    q.offer(i);
                }
            }
        }
        
    }
}