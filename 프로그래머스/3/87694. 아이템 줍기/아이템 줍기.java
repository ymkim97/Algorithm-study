import java.util.*;

class Solution {
    
    int[][] map;
    int[][] visited;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[102][102];
        visited = new int[102][102];
        
        for (int[] rec : rectangle) {
            for (int i = 0; i < 4; i++) {
                rec[i] *= 2;
            }
            
            draw(rec);
        }
        
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return (visited[itemX * 2][itemY * 2] - 1) / 2;
    }
    
    public void draw(int[] rec) {
        int x1 = rec[0];
        int y1 = rec[1];
        int x2 = rec[2];
        int y2 = rec[3];
        
        for (int i = x1; i <= x2; i++) { // 가로 외각
            if (map[i][y1] == 0 || map[i][y1] == 1) {
                map[i][y1] = 1;
            } else {
                map[i][y1] = 2;
            }
            
            if (map[i][y2] == 0 || map[i][y2] == 1) {
                map[i][y2] = 1;
            } else {
                map[i][y2] = 2;
            }
        }
        
        for (int i = y1; i <= y2; i++) { // 세로 외각
            if (map[x1][i] == 0 || map[x1][i] == 1) {
                map[x1][i] = 1;
            } else {
                map[x1][i] = 2;
            }
            
            if (map[x2][i] == 0 || map[x2][i] == 1) {
                map[x2][i] = 1;
            } else {
                map[x2][i] = 2;
            }
        }
        
        for (int i = x1 + 1; i < x2; i++) {
            for (int j = y1 + 1; j < y2; j++) {
                map[i][j] = 2;
            }
        }
    }
    
    public void bfs(int a, int b, int itemX, int itemY) {
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, b});
        visited[a][b] = 1;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            if (x == itemX && y == itemY) {
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= 102 || dy >= 102 || visited[dx][dy] > 0) continue;
                if (map[dx][dy] != 1) continue;
                
                visited[dx][dy] = visited[x][y] + 1;
                q.offer(new int[] {dx, dy});
            }
        }
    }
}