import java.util.*;

class Solution {
    
    int[] mx = {1, -1, 0, 0};
    int[] my = {0, 0, 1, -1};
    
    public int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();
        
        for (String[] place : places) {
            char[][] map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                map[i] = place[i].toCharArray();
            }
            
            answer.add(check(map));
        }
        
        return answer.stream().mapToInt(a -> a).toArray();
    }
    
    public int check(char[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P' && !bfs(i, j, map)) {
                    return 0;
                }
            }
        }
        
        return 1;
    }
    
    public boolean bfs(int a, int b, char[][] map) {
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < 4; i++) {
            int dx = a + mx[i];
            int dy = b + my[i];
            
            if (dx < 0 || dy < 0 || dx >= 5 || dy >= 5 || map[dx][dy] == 'X') continue;
            
            if (map[dx][dy] == 'P') return false;
            
            q.offer(new int[] {dx, dy});
        }
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= 5 || dy >= 5 || (dx == a && dy == b)) continue;
                
                if (map[dx][dy] == 'P') return false;
            }
        }
        
        return true;
    }
}