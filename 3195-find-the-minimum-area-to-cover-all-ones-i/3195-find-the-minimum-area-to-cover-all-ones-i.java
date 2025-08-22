class Solution {
    public int minimumArea(int[][] grid) {
        int minX = 1001;
        int maxX = 0;
        int minY = 1001;
        int maxY = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);

                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        return (maxX - minX + 1) * (maxY - minY + 1);
    }
}