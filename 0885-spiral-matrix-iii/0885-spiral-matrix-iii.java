class Solution {
        public int[][] spiralMatrixIII(int R, int C, int x, int y) {
        int[][] res = new int[R * C][2];
        int dx = 0;
        int dy = 1;
        int n = 0;
        int tmp = 0;

        for (int j = 0; j < R * C; n++) {
            for (int i = 0; i < n / 2 + 1; i++) {
                if (0 <= x && x < R && 0 <= y && y < C)
                    res[j++] = new int[] {x, y};
                x += dx;
                y += dy;
            }
            
            tmp = dx;
            dx = dy;
            dy = -tmp;
        }

        return res;
    }
}