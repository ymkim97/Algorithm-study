class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        boolean even = true;

        while(!q.isEmpty()) {
            int size = q.size();
            int prevVal = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			while(size-- > 0) {
                root = q.poll();
                if(even && (root.val % 2 == 0 || root.val <= prevVal)) return false; // invalid case on even level
                if(!even && (root.val % 2 == 1 || root.val >= prevVal)) return false; // invalid case on odd level
                prevVal = root.val; // update the prev value
                if(root.left != null) q.add(root.left); // add left child if exist
                if(root.right != null) q.add(root.right); // add right child if exist
            }

            even = !even;
        }
        
        return true;
    }
}