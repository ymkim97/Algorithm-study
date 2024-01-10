import java.util.*;

class Solution {
    
    List<List<Integer>> graph;
    int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList<>();
        dist = new int[n + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList());
        }
        
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        bfs(destination);
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (dist[sources[i]] < Integer.MAX_VALUE) ? dist[sources[i]] : -1;
        }
        
        return answer;
    }
    
    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                
                if (dist[next] > dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}