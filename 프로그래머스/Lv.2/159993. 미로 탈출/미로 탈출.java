/**
 1. 먼저 Start -> Lever 최단
 2. Lever -> Exit 최단
 3. return 1 + 2
*/
import java.util.*;

class Solution {
    
    char[][] map;
    
    public int solution(String[] maps) {
        int answer = 0;
        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int exitX = 0, exitY = 0;
        map = new char[maps.length][];
        
        for (int i = 0; i < map.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < map.length; i++) { // S, L, E 위치 찾기
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                
                else if (map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
                
                else if (map[i][j] == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }
        
        answer += bfs(startX, startY, leverX, leverY);
        
        if (answer == -1) {
            return -1;
        }
        
        int toExit = bfs(leverX, leverY, exitX, exitY);
        
        if (toExit == -1) {
            return -1;
        }
        
        return answer + toExit;
    }
    
    public int bfs(int startX, int startY, int endX, int endY) {
        int[][] visited = new int[map.length][map[0].length];
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY});
        visited[startX][startY] = 0;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];
            
            if (x == endX && y == endY) {
                return visited[endX][endY];
            }
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= map.length || dy >= map[0].length || visited[dx][dy] != -1) continue;
                if (map[dx][dy] == 'X') continue;
                
                visited[dx][dy] = visited[x][y] + 1;
                
                q.offer(new int[] {dx, dy});
            }
        }
        
        return visited[endX][endY];
    }
}