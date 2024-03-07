/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int middle = getTotalDepth(head, 1) / 2 + 1;

        return getMiddle(head, middle, 1);
    }

    public int getTotalDepth(ListNode node, int depth) {
        if (node.next == null) {
            return depth;
        }

        return getTotalDepth(node.next, depth + 1);
    }

    public ListNode getMiddle(ListNode node, int targetDepth, int depth) {
        if (targetDepth == depth) {
            return node;
        }

        return getMiddle(node.next, targetDepth, depth + 1);
    }
}