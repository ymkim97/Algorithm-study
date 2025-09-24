import java.util.*;

class Solution {
    
    int[] mx = {1, -1, 0, 0};
    int[] my = {0, 0, 1, -1};
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] board, int r, int c) {        
        Map<Integer, List<Point>> cards = new HashMap<>();
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    cards.putIfAbsent(board[i][j], new ArrayList<>());
                    cards.get(board[i][j]).add(new Point(i, j));
                }
            }
        }
        
        dfs(board, r, c, cards, new ArrayList<>());
        
        return answer;
    }

    public void dfs(int[][] board, int r, int c, Map<Integer, List<Point>> cards, List<Integer> order) {
        if (order.size() == cards.size()) {
            simulate(board, r, c, cards, order, 0, 0);
            return;
        }
        
        for (int key : cards.keySet()) {
            if (!order.contains(key)) {
                order.add(key);
                dfs(board, r, c, cards, order);
                order.remove(order.size() - 1);
            }
        }
    }
    
    public void simulate(int[][] board, int r, int c, Map<Integer, List<Point>> cards, List<Integer> order, int curOrder, int moves) {
        if (moves >= answer) return;
        
        if (curOrder == order.size()) {
            answer = Math.min(answer, moves);
            return;
        }
        
        int card = order.get(curOrder);
        Point p1 = cards.get(card).get(0);
        Point p2 = cards.get(card).get(1);
        
        // 1. p1 -> p2 순서
        int d1 = bfs(board, r, c, p1) + bfs(board, p1.x, p1.y, p2) + 2; // 이동 + Enter 2번
        board[p1.x][p1.y] = 0;
        board[p2.x][p2.y] = 0;
        simulate(board, p2.x, p2.y, cards, order, curOrder + 1, moves + d1);
        board[p1.x][p1.y] = card;
        board[p2.x][p2.y] = card;
        
        // 2. p2 -> p1 순서
        int d2 = bfs(board, r, c, p2) + bfs(board, p2.x, p2.y, p1) + 2;
        board[p1.x][p1.y] = 0;
        board[p2.x][p2.y] = 0;
        simulate(board, p1.x, p1.y, cards, order, curOrder + 1, moves + d2);
        board[p1.x][p1.y] = card;
        board[p2.x][p2.y] = card;
    }
    
    // BFS로 최소 이동 횟수 구하기
    public int bfs(int[][] board, int r, int c, Point target) {
        boolean[][] visited = new boolean[4][4];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});
        visited[r][c] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1], dist = now[2];
            
            if (x == target.x && y == target.y) {
                return dist;
            }
            
            // 방향키 한 칸 이동
            for (int i = 0; i < 4; i++) {
                int dx = x + mx[i];
                int dy = y + my[i];
                
                if (dx < 0 || dy < 0 || dx >= 4 || dy >= 4) continue;
                if (!visited[dx][dy]) {
                    visited[dx][dy] = true;
                    q.offer(new int[]{dx, dy, dist + 1});
                }
                
                // Ctrl 이동
                int cx = x;
                int cy = y;
                
                while (true) {
                    int nx = cx + mx[i];
                    int ny = cy + my[i];
                    if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;
                    
                    cx = nx;
                    cy = ny;
                    
                    if (board[cx][cy] != 0) break;
                }
                if (!visited[cx][cy]) {
                    visited[cx][cy] = true;
                    q.offer(new int[]{cx, cy, dist + 1});
                }
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
