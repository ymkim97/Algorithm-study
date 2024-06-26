/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<TreeNode> lst = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrderTraverse(root);
        return sortedArrayToBST(00, lst.size() - 1);
    }

    public void inOrderTraverse(TreeNode node) {
        if (node == null) return;
        
        inOrderTraverse(node.left);
        lst.add(node);
        inOrderTraverse(node.right);
    }

    public TreeNode sortedArrayToBST(int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = lst.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        
        return root;
    }
}