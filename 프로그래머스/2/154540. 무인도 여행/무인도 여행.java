import java.util.*;

class Solution {
    
    private static int[] mx = {1, -1, 0, 0};
    private static int[] my = {0, 0, 1, -1};
    private int n, m;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        List<Integer> answer = new ArrayList<>();
        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0;i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 'X') bfs(i, j, map, visited, answer);
            }
        }
        
        Collections.sort(answer);
        
        return answer.isEmpty() ? new int[] {-1} : answer.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    public void bfs(int a, int b, char[][] map, boolean[][] visited, List<Integer> answer) {        
        Queue<int[]> q = new LinkedList<>();
        visited[a][b] = true;
        q.offer(new int[] {a, b});
        int count = Character.getNumericValue(map[a][b]);
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy] || map[dx][dy] == 'X') continue;
                
                visited[dx][dy] = true;
                count += Character.getNumericValue(map[dx][dy]);
                q.offer(new int[] {dx, dy});
            }
        }
        
        answer.add(count);
    }
}