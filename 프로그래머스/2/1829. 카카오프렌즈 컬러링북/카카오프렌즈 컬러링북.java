import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea += 1;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(picture, i, j, visited, m, n));
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    public int bfs(int[][] picture, int a, int b, boolean[][] visited, int m, int n) {
        int size = 1;
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        visited[a][b] = true;
        q.offer(new int[] {a, b});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= m || dy >= n || visited[dx][dy] || picture[a][b] != picture[dx][dy]) continue;
                
                size += 1;
                visited[dx][dy] = true;
                q.offer(new int[] {dx, dy});
            }
        }
        
        return size;
    }
}