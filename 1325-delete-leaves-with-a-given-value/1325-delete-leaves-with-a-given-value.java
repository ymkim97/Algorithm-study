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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    public TreeNode dfs(TreeNode node, int target) {
        if (node.left != null) node.left = dfs(node.left, target);
        if (node.right != null) node.right = dfs(node.right, target);

        if (node.left == null && node.right == null) {
            if (node.val == target) return null;

            return node;
        }

        return node;
    }
}