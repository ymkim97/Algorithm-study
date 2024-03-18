class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int EMPTY = 0;
        int WALL = 1;
        int STRICT = 2;
        
        int LEFT = 0;
        int UP = 1;
        
        int[][][] board = new int[m][n][2];
        
        for (int i = 0; i < n; i++) {
            if (cityMap[0][i] == WALL) break;
            board[0][i][LEFT] = 1;
        }
        
        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == WALL) break;
            board[i][0][UP] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                
                if (cityMap[i][j] == WALL) continue;
                
                int left = board[i][j - 1][LEFT];
                
                if (cityMap[i][j - 1] == EMPTY) {
                    left = (left + board[i][j - 1][UP]) % MOD;
                }
                
                int up = board[i - 1][j][UP];
                
                if (cityMap[i - 1][j] == EMPTY) {
                    up = (up + board[i - 1][j][LEFT]) % MOD;
                }
                
                board[i][j][UP] = up;
                board[i][j][LEFT] = left;
            }
        }
        
        return (board[m - 1][n - 1][LEFT] + board[m - 1][n - 1][UP]) % MOD;
    }
}