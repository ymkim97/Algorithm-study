import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<Integer>[] map = new ArrayList[n + 1];
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            if (map[a] == null) map[a] = new ArrayList<>();
            if (map[b] == null) map[b] = new ArrayList<>();
            
            map[a].add(b);
            map[b].add(a);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            map[a].remove(Integer.valueOf(b));
            map[b].remove(Integer.valueOf(a));
            
            int cnt1 = bfs(a, map);
            int cnt2 = bfs(b, map);
            
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
            
            map[a].add(b);
            map[b].add(a);
        }
        
        return answer;
    }
    
    public int bfs(int start, List<Integer>[] map) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;
        
        q.offer(start);
        visited.add(start);
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : map[now]) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.offer(next);
                    cnt += 1;
                }
            }
        }
        
        return cnt;
    }
}