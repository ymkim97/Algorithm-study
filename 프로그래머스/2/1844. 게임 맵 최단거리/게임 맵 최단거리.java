import java.util.*;

class Solution {
    
    boolean[][] visited;
    int m, n;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        bfs(0, 0, maps);
        
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
    
    public void bfs(int a, int b, int[][] maps) {
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visited[a][b] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy]) continue;
                if (maps[dx][dy] != 1) continue;
                
                maps[dx][dy] = maps[x][y] + 1;
                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy});
            }
            
        }
    }
}