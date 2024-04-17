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

    Queue<String> pq = new PriorityQueue<>();

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new ArrayList<>());
        return pq.poll();
    }

    public void dfs(TreeNode node, List<Integer> lst) {
        lst.add(node.val);

        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();

            for (int t : lst) {
                sb.append((char)(t + 97));
            }

            pq.offer(sb.reverse().toString());
            
            return;
        }

        if (node.left != null) dfs(node.left, new ArrayList<>(lst));
        if (node.right != null) dfs(node.right, new ArrayList<>(lst));
    }
}