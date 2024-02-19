import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        Set<Node> set = new HashSet<>();
        int nowX = 0;
        int nowY = 0;
        
        for (char dir : dirs.toCharArray()) {
            int dx = 0;
            int dy = 0;
            
            if (dir == 'U') {
                dx = nowX;
                dy = nowY + 1;
                if (!validate(dx, dy)) continue;
            }
            
            else if (dir == 'D') {
                dx = nowX;
                dy = nowY - 1;
                if (!validate(dx, dy)) continue;
            }
            
            else if (dir == 'L') {
                dx = nowX - 1;
                dy = nowY;
                if (!validate(dx, dy)) continue;
            }
            
            else if (dir == 'R') {
                dx = nowX + 1;
                dy = nowY;
                if (!validate(dx, dy)) continue;
            }
            
            Node node1 = new Node(dx, dy, nowX, nowY);
            Node node2 = new Node(nowX, nowY, dx, dy);
            set.add(node1);
            set.add(node2);
            
            nowX = dx;
            nowY = dy;
        }
        
        return set.size() / 2;
    }
    
    public boolean validate(int x, int y) {
        if (x < -5 || y < -5 || x > 5 || y > 5) return false;
        
        return true;
    }
    
    static class Node {
        int x;
        int y;
        int prevX;
        int prevY;
        
        public Node(int x, int y, int prevX, int prevY) {
            this.x = x;
            this.y = y;
            this.prevX = prevX;
            this.prevY = prevY;
        }
        
        @Override
        public boolean equals(Object o) {
            Node comp = (Node)o;
            
            if (this.x == comp.x && this.y == comp.y && this.prevX == comp.prevX && this.prevY == comp.prevY) {
                return true;
            }
            
            return false;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y, prevX, prevY);
        }
    }
}