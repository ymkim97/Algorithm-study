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
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    public boolean dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            if (node.val == 1) return true;

            return false;
        }

        if (node.val == 2) {
            return dfs(node.left) || dfs(node.right);
        } else {
            return dfs(node.left) && dfs(node.right);
        }
    }
}