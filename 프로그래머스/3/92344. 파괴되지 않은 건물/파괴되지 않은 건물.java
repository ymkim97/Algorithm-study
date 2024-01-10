class Solution {
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] tmp = new int[N + 1][M + 1];
        
        for(int[] sk : skill) {
            int type = sk[0];
            int r1 = sk[1], c1 = sk[2];
            int r2 = sk[3], c2 = sk[4];
            int degree = sk[5];
            
            if (type == 1) {
                tmp[r1][c1] += -degree;
                tmp[r1][c2 + 1] += degree;
                tmp[r2 + 1][c1] += degree;
                tmp[r2 + 1][c2 + 1] += -degree;
            } else {
                tmp[r1][c1] += degree;
                tmp[r1][c2 + 1] += -degree;
                tmp[r2 + 1][c1] += -degree;
                tmp[r2 + 1][c2 + 1] += degree;
            }
        }
        
        // 가로 합
        for (int i = 0; i <= N; i++) {
            int sum = 0;
            
            for (int j = 0; j <= M; j++) {
                sum += tmp[i][j];
                tmp[i][j] = sum;
            }
        }
        
        // 세로 합
        for (int i = 0; i <= M; i++) {
            int sum = 0;
            
            for (int j = 0; j <= N; j++) {
                sum += tmp[j][i];
                tmp[j][i] = sum;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] + board[i][j] > 0) answer += 1;
            }
        }
        
        return answer;
    }
}