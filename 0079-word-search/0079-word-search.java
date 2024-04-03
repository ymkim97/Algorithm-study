class Solution {

    int m, n;
    boolean[][] visited;
    int[] mx = {1, -1, 0, 0};
    int[] my = {0, 0, 1, -1};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(word.charAt(0) == board[i][j]) {
                    visited = new boolean[m][n];

                    if (dfs(i, j, word, board, 1)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int x, int y, String word, char[][] board, int idx) {
        if (idx == word.length()) return true;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + mx[i];
            int dy = y + my[i];

            if (dx < 0 || dy < 0 || dx >= m || dy >= n || visited[dx][dy] || board[dx][dy] != word.charAt(idx)) continue;

            visited[dx][dy] = true;
            if (dfs(dx, dy, word, board, idx + 1)) return true;
            visited[dx][dy] = false;
        }

        return false;
    }
}