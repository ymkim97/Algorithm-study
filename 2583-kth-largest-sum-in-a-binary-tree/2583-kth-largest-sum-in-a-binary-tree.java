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

    PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));

        int currentLevel = 1;
        long tmp = 0;
        
        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (currentLevel != p.level) {
                System.out.println(tmp);
                pq.offer(tmp);
                currentLevel = p.level;
                tmp = 0;
            }

            tmp += p.node.val;

            if (p.node.left != null) q.offer(new Pair(p.node.left, currentLevel + 1));
            if (p.node.right != null) q.offer(new Pair(p.node.right, currentLevel + 1));
        }

        if (tmp != 0) pq.offer(tmp);

        if (pq.size() < k) return -1;

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        return pq.poll();
    }

    static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}