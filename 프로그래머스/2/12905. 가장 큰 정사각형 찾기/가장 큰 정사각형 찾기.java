class Solution {
    
    public int solution(int[][] board) {    
        int x = board.length;
        int y = board[0].length;
        int max = 0;
        
        if(x <= 1 || y <= 1) return 1;
        
        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                if(board[i][j] >= 1){
                    int up = board[i - 1][j];
                    int left = board[i][j - 1];
                    int upperLeft = board[i - 1][j - 1];
                    int min = Math.min(up, left);
                    min = Math.min(min, upperLeft);
                    board[i][j] = min + 1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        
        return max * max;
    }
}