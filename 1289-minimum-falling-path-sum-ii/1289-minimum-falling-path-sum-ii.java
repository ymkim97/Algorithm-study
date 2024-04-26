class Solution {

    int answer = Integer.MAX_VALUE;
    int n;

    public int minFallingPathSum(int[][] grid) {
        n = grid.length;
        dfs(grid, 0, 0, -1);

        return answer;
    }

    public void dfs(int[][] grid, int depth, int sum, int prevIdx) {
        if (depth == n) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == prevIdx) continue;

            dfs(grid, depth + 1, sum + grid[depth][i], i);
        }
    }
}