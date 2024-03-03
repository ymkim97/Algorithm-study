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

    boolean changed = false;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int d = dfs(head, n);

        if (d == n && !changed) {
            head = head.next;
        }

        return head;   
    }

    public int dfs(ListNode node, int n) {
        if (node.next == null) {
            return 1;
        }

        int nextNodeDepth = dfs(node.next, n);

        if (nextNodeDepth == n) {
            node.next = node.next.next;
            changed = true;
            return 1000;
        }

        else {
            return nextNodeDepth + 1;
        }
    }
}