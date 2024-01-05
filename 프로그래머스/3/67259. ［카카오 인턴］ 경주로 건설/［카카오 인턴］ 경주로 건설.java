import java.util.*;

class Solution {
    
    int[] nx = {-1, 1, 0, 0};
    int[] ny = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int answer = 0;
        int N = board.length;
        int[][][] cost = new int[N][N][4];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0, 1});
        q.offer(new int[] {0, 0, 0, 3});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int k = 0; k < 4; k++){
                int dx = cur[0] + nx[k];
                int dy = cur[1] + ny[k];
                int c = cur[2] + (cur[3] == k ? 100 : 600);
                
                if (dy < 0 || dx < 0 || dy >= N || dx >= N || board[dx][dy] == 1 || cost[dx][dy][k] <= c) continue;
                
                cost[dx][dy][k] = c;
                q.offer(new int[] {dx, dy, c, k});
            }
        }
        
        return Arrays.stream(cost[N - 1][N - 1]).min().getAsInt();
    }
}