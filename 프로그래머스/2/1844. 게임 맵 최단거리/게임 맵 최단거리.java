import java.util.*;

class Solution {
    public int solution(int[][] map) {
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy] || map[dx][dy] == 0) continue;
                
                visited[dx][dy] = true;
                map[dx][dy] = map[x][y] + 1;
                
                q.offer(new int[] {dx, dy});
            }
        }   
        
        return visited[n - 1][m - 1] ? map[n - 1][m - 1] : -1;
    }
}