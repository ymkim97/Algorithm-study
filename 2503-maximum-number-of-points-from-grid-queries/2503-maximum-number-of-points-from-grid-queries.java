class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] answer = new int[queries.length];
        int r = grid.length;
        int c = grid[0].length;
        int[][] dirs = { {0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0 ; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[r][c];

        int totalPoints = 0;
        pq.offer(new int[] {grid[0][0], 0, 0}); // cell, x, y
        visited[0][0] = true;

        for (int[] query : sortedQueries) {
            int val = query[0];
            int idx = query[1];

            while (!pq.isEmpty() && pq.peek()[0] < val) {
                int[] polled = pq.poll();
                int cellVal = polled[0];
                int cellX = polled[1];
                int cellY = polled[2];

                totalPoints += 1;

                for (int[] dir : dirs) {
                    int nx = cellX + dir[0];
                    int ny = cellY + dir[1];

                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny]) {
                        pq.offer(new int[] {grid[nx][ny], nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            answer[idx] = totalPoints;
        }

        return answer;
    }
}