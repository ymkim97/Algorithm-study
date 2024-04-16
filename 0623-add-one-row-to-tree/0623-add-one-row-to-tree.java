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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val, root, null);
            return newNode;
        }

        dfs(root, 1, val, depth);
        return root;
    }

    public void dfs(TreeNode node, int depth, int val, int targetDepth) {
        if (depth + 1 == targetDepth) {
            if (node.left != null) {
                TreeNode newNode = new TreeNode(val, node.left, null);
                node.left = newNode;
            } else {
                node.left = new TreeNode(val, null, null);
            }

            if (node.right != null) {
                TreeNode newNode = new TreeNode(val, null, node.right);
                node.right = newNode;
            } else {
                node.right = new TreeNode(val, null, null);
            }

            return;
        }

        if (node.left != null) dfs(node.left, depth + 1, val, targetDepth);
        if (node.right != null) dfs(node.right, depth + 1, val, targetDepth);
    }
}