import java.util.*;

class Solution {
    
    Point[][] parent = new Point[51][51];
    String[][] board = new String[51][51];
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                parent[i][j] = new Point(i, j);
            }
        }
        
        for (String command : commands) {
            String[] cmd = command.split(" ");
            String action = cmd[0];
            
            if (action.equals("UPDATE") && cmd.length == 4) {
                int r = Integer.parseInt(cmd[1]);
                int c = Integer.parseInt(cmd[2]);
                
                Point p = find(r, c);

                board[p.x][p.y] = cmd[3];
            }
            
            else if (action.equals("UPDATE") && cmd.length == 3) {
                updateValues(cmd[1], cmd[2]);
            }
            
            else if (action.equals("MERGE")) {
                int r1 = Integer.parseInt(cmd[1]);
                int c1 = Integer.parseInt(cmd[2]);
                int r2 = Integer.parseInt(cmd[3]);
                int c2 = Integer.parseInt(cmd[4]);
                
                merge(r1, c1, r2, c2);
            }
            
            else if (action.equals("UNMERGE")) {
                int r = Integer.parseInt(cmd[1]);
                int c = Integer.parseInt(cmd[2]);
                
                unMerge(r, c);
            }
            
            else if (action.equals("PRINT")) {
                int r = Integer.parseInt(cmd[1]);
                int c = Integer.parseInt(cmd[2]);
                
                Point p = find(r, c);
                
                if (board[p.x][p.y] == null || board[p.x][p.y].isEmpty()) {
                    answer.add("EMPTY");
                    continue;
                }

                answer.add(board[p.x][p.y]);
            }
        }
        
        return answer.toArray(new String[0]);
    }
    
    public void updateValues(String from, String to) {
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (board[i][j] != null && board[i][j].equals(from)) board[i][j] = to;
            }
        }
    }
    
    public void merge(int r1, int c1, int r2, int c2) {
        Point firstParent = find(r1, c1);
        Point secondParent = find(r2, c2);
        
        if (!firstParent.equals(secondParent)) union(firstParent, secondParent);
    }
    
    public void unMerge(int r, int c) {
        Point p = find(r, c);
        String tmp = board[p.x][p.y];
        
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (find(i, j).equals(p)) {
                    parent[i][j] = new Point(i, j);
                    board[i][j] = null;
                }
            }
        }
        
        board[r][c] = tmp;
    }
    
    public Point find(int x, int y) {      
        if (parent[x][y].x == x && parent[x][y].y == y) return new Point(x, y);
        
        return find(parent[x][y].x, parent[x][y].y);
    }
    
    public void union(Point a, Point b) {
        String tmp1 = board[a.x][a.y];
        String tmp2 = board[b.x][b.y];
        String change = null;
        
        if (tmp1 != null && tmp2 != null) change = tmp1;
        else if (tmp1 != null && tmp2 == null) change = tmp1;
        else if (tmp1 == null && tmp2 != null) change = tmp2;
        
        if (a.x < b.x) {
            parent[b.x][b.y] = a;
            board[a.x][a.y] = change;
            for (int i = 1; i < 51; i++) {
                for (int j = 1; j < 51; j++) {
                    if (parent[i][j].equals(b)) {
                        parent[i][j] = a;
                        board[i][j] = change;
                    }
                }
            }
        }
        
        else {
            if (a.x == b.x) {
                if (a.y < b.y) {
                    parent[b.x][b.y] = a;
                    board[a.x][a.y] = change;
                     for (int i = 1; i < 51; i++) {
                        for (int j = 1; j < 51; j++) {
                            if (parent[i][j].equals(b)) {
                                parent[i][j] = a;
                                board[i][j] = change;
                            }
                        }
                    }
                }
                
                else {
                    parent[a.x][a.y] = b;
                    board[b.x][b.y] = change;
                    for (int i = 1; i < 51; i++) {
                        for (int j = 1; j < 51; j++) {
                            if (parent[i][j].equals(a)) {
                                parent[i][j] = b;
                                board[i][j] = change;
                            }
                        }
                    }
                }
            }
            
            else {
                parent[a.x][a.y] = b;
                board[b.x][b.y] = change;
                for (int i = 1; i < 51; i++) {
                    for (int j = 1; j < 51; j++) {
                        if (parent[i][j].equals(a)) {
                            parent[i][j] = b;
                            board[i][j] = change;
                        }
                    }
                }
            }
        }
        
        
    }    
    
    static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Point p = (Point)o;
            
            if (this.x == p.x && this.y == p.y) return true;
            
            return false;
        }
    }
}