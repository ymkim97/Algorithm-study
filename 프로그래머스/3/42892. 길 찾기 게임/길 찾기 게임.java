import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        List<Node> nodes = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; i++) { // node 생성
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        nodes.sort((a, b) -> { // y 내림차순으로, 같으면 x 올름차순으로 정렬
            if (a.y == b.y) return a.x - b.x;
            else return b.y - a.y;
        });
        
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) { // 루트 노드부터 각각 child 설정
            root.setChild(nodes.get(i));
        }
        
        preOrder(pre, root);
        postOrder(post, root);
        
        answer[0] = pre.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = post.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    public void preOrder(List<Integer> pre, Node node) {
        if (node == null) return;
        
        pre.add(node.number);
        preOrder(pre, node.left);
        preOrder(pre, node.right);
    }
    
    public void postOrder(List<Integer> post, Node node) {
        if (node == null) return;
        
        postOrder(post, node.left);
        postOrder(post, node.right);
        post.add(node.number);
    }
    
    static class Node {
        int number;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node (int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
        
        public void setChild(Node child) {
            if (this.x < child.x) {
                if (this.right == null) this.right = child;
                else this.right.setChild(child);
            }
            
            else {
                if (this.left == null) this.left = child;
                else this.left.setChild(child);
            }
        }
    }
}