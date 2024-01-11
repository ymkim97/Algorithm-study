import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Node cursor = init(n);
        
        for (int i = 0; i < k; i++) {
            cursor = cursor.next;
        }
        
        Stack<Node> delStack = new Stack();
        for (String command : cmd) {
            String[] cd = command.split(" ");
            
            if (command.charAt(0) == 'U') {
                for (int i = 0; i < Integer.parseInt(cd[1]); i++) {
                    if (cursor.prev.idx != -1) {
                        cursor = cursor.prev;
                    }
                }
            }
            
            else if (command.charAt(0) == 'D') {
                for (int i = 0; i < Integer.parseInt(cd[1]); i++) {
                    if (cursor.next.idx != -1) {
                        cursor = cursor.next;
                    }
                }
            }
            
            else if (command.charAt(0) == 'C') {
                delStack.push(cursor);
                cursor = cursor.remove();
            }
            
            else if (command.charAt(0) == 'Z') {
                Node toRepair = delStack.pop();
                toRepair.repair();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append("O");
        }
        
        while (!delStack.isEmpty()) {
            sb.setCharAt(delStack.pop().idx, 'X');
        }
        
        return sb.toString();
    }
    
    public Node init(int n) {
        Node root = new Node(-1);
        Node cur = root;
        
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            
            cur.connect(node);
            cur = node;
        }
        
        Node end = new Node(-1);
        cur.next = end;
        return root.next;
    }
    
    static class Node {
        int idx;
        Node next;
        Node prev;
        
        public Node(int idx) {
            this.idx = idx;
        }
        
        public void connect(Node node) {
            this.next = node;
            node.prev = this;
        }
        
        public Node remove() {
            prev.next = next;
            next.prev = prev;
            
            if (next.idx == -1) {
                return prev;
            }
            
            return next;
        }
        
        public void repair() {
            prev.next = this;
            next.prev = this;
        }
    }
}