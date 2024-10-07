import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] charBoard = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                charBoard[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            List<int[]> blocksToPop = new ArrayList<>();
            
            checkBlocks(blocksToPop, m, n, charBoard);
            
            if (blocksToPop.size() == 0) break;
            
            answer += popBlocksAndMove(blocksToPop, m, n, charBoard);
        }
        
        return answer;
    }
    
    public void checkBlocks(List<int[]> blocksToPop, int m, int n, char[][] board) {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char a = board[i][j];                
                char b = board[i][j + 1];
                char c = board[i + 1][j];
                char d = board[i + 1][j + 1];
                
                if (a == '.' || b == '.' || c == '.' || d == '.') continue;
                
                if (a == b && b == c && c == d) {
                    blocksToPop.add(new int[] {i, j});
                    blocksToPop.add(new int[] {i, j + 1});
                    blocksToPop.add(new int[] {i + 1, j});
                    blocksToPop.add(new int[] {i + 1, j + 1});
                }
            }
        }
    }
    
    public int popBlocksAndMove(List<int[]> blocksToPop, int m, int n, char[][] board) {
        int popCount = 0;
        
        for (int[] p : blocksToPop) {
            int x = p[0];
            int y = p[1];
            
            if (board[x][y] != '.') {
                popCount += 1;
                board[x][y] = '.';
            }
        }
        
        for (int i = m - 1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                
                if (board[i][j] == '.') {
                    int tmpPoint = i;
                    for (int a = i - 1; a >= 0; a--) {
                        if (board[a][j] != '.') {
                            tmpPoint = a;
                            break;
                        }
                    }
                    
                    if (tmpPoint != i) {
                        board[i][j] = board[tmpPoint][j];
                        board[tmpPoint][j] = '.';
                    }
                }
            }
        }
        
        return popCount;
    }
}