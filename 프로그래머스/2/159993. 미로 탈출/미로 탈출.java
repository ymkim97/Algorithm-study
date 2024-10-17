import java.util.*;

class Solution {
    
    private static int[] mx = {1, -1, 0, 0};
    private static int[] my = {0, 0, 1, -1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int sX = 0, sY = 0;
        int eX = 0, eY = 0;
        int lX = 0, lY = 0;
        
        char[][] map = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    sX = i;
                    sY = j;
                } else if (map[i][j] == 'E') {
                    eX = i;
                    eY = j;
                } else if (map[i][j] == 'L') {
                    lX = i;
                    lY = j;
                }
            }
        }
        
        int toLever = bfs(sX, sY, lX, lY, map);
        if (toLever == -1) return -1;
        
        int toExit = bfs(lX, lY, eX, eY, map);
        if (toExit == -1) return -1;
        
        return toLever + toExit;
    }
    
    public int bfs(int a, int b, int targetX, int targetY, char[][] map) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[map.length][map[0].length];
        
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        visited[a][b] = 0;
        q.offer(new int[] {a, b});        
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            if (x == targetX && y == targetY) return visited[x][y];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= map.length || dy >= map[0].length || visited[dx][dy] != -1 || map[dx][dy] == 'X') continue;
                
                visited[dx][dy] = visited[x][y] + 1;
                q.offer(new int[] {dx, dy});
            }
        }
        
        return -1;
    }
}