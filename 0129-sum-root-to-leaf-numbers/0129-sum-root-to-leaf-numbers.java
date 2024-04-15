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

    int answer = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        return answer;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        sb.append(node.val);

        if (node.left == null && node.right == null) { // leaf node
            answer += Integer.parseInt(sb.toString());
            return;
        }

        if (node.left != null) {
            dfs(node.left, new StringBuilder(sb));
        }

        if (node.right != null) {
            dfs(node.right, new StringBuilder(sb));
        }
    }
}