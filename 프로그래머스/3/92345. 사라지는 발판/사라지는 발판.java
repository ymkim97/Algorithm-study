class Solution {
    
    int[][] board;
    int N, M;
    int[] mx = {1, -1, 0, 0};
    int[] my = {0, 0, 1, -1};
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.N = board.length;
        this.M = board[0].length;
        this.board = board;
        
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
    
    public int dfs(int playerX, int playerY, int opX, int opY) {
        if (board[playerX][playerY] == 0) return 0;
        
        int result = 0;
        
        for (int i = 0; i < 4; i++) {
            int nx = playerX + mx[i];
            int ny = playerY + my[i];
            
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 0) continue;
            
            board[playerX][playerY] = 0;
            int val = dfs(opX, opY, nx, ny) + 1;
            board[playerX][playerY] = 1;
            
            if(result % 2 == 0 && val % 2 == 1) {
                result = val;
            }
                
            else if(result % 2 == 0 && val % 2 == 0) {
                result = Math.max(result, val);
            }
            
            else if(result % 2 == 1 && val % 2 == 1) {
                result = Math.min(result, val);
            }
        }
        
        return result;
    }
}