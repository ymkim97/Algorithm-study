import java.util.*;

class Solution {
    
    public int solution(String[] oldBoard) {
        int answer = Integer.MAX_VALUE;
        int rX = 0, rY = 0;
        int gX = 0, gY = 0;
        int n = oldBoard.length, m = oldBoard[0].length();
        char[][] board = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            board[i] = oldBoard[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    rX = i;
                    rY = j;
                }
                
                else if (board[i][j] == 'G') {
                    gX = i;
                    gY = j;
                }
            }
        }
        
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        q.offer(new int[] {rX, rY});
        visited[rX][rY] = 0;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            if (x == gX && y == gY) {
                answer = Math.min(answer, visited[x][y]);
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int dx = x;
                int dy = y;
                
                while (true) {
                    dx += mx[i];
                    dy += my[i];
                    
                    if (dx < 0 || dy < 0 || dx >= n || dy >= m || board[dx][dy] == 'D') {
                        dx -= mx[i];
                        dy -= my[i];
                        break;
                    }
                }
                
                if (visited[dx][dy] == -1) {
                    visited[dx][dy] = visited[x][y] + 1;
                    q.offer(new int[] {dx, dy});
                }
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}