import java.util.*;

class Solution {
    
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        Map<Point, List<Point>> visited = new HashMap<>();
        Point now = new Point(0, 0);
        
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                Point next = new Point(now.x + dx[arrow], now.y + dy[arrow]);
                
                if (!visited.containsKey(next)) {
                    visited.put(next, toList(now));
                    
                    if (!visited.containsKey(now)) {
                        visited.put(now, toList(next));
                    }
                    
                    else {
                        visited.get(now).add(next);
                    }
                }
                
                else if (visited.containsKey(next) && !visited.get(next).contains(now)) {
                    visited.get(next).add(now);
                    visited.get(now).add(next);

                    answer++;
                }
                
                now = next;
            }
        }
        
        return answer;
    }
    
    public List<Point> toList(Point point) {
        List<Point> list = new ArrayList<>();
        list.add(point);
        
        return list;
    }
    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return (this.x == point.x) && (this.y == point.y);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }
}