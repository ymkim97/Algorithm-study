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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        ListNode tmp1 = null;
        ListNode tmp2 = null;

        for (int i = 0; i <= b; i++) {
            if (i == a - 1) {
                tmp1 = cur;
            }

            if (i == b) {
                tmp2 = cur.next;
            }

            cur = cur.next;
        }

        tmp1.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = tmp2;

        return list1;
    }
}