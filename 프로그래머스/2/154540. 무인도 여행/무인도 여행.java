import java.util.*;

class Solution {
    
    int[] mx = {1, -1, 0, 0};
    int[] my = {0, 0, 1, -1};
    boolean[][] visited;
    int n, m;
    List<Integer> answer = new ArrayList<>();
    int[][] maps;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        this.maps = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X') {
                    this.maps[i][j] = Character.getNumericValue(maps[i].charAt(j));
                }
                else {
                    this.maps[i][j] = -1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && this.maps[i][j] != -1) {
                    answer.add(bfs(i, j));
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.isEmpty() ? new int[] {-1} : answer.stream().mapToInt(a -> a).toArray();
    }
    
    public int bfs(int a, int b) {
        int sum = maps[a][b];
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
                
                if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy] || maps[dx][dy] == -1) continue;
                
                visited[dx][dy] = true;
                sum += maps[dx][dy];
                q.offer(new int[] {dx, dy});
            }
        }
        
        return sum;
    }
}