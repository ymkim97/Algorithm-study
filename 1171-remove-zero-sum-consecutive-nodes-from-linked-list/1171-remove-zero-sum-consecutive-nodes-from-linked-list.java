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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        map.put(0, dummy);
        ListNode cur = head;

        int sum = 0;

        while (cur != null) {
            sum += cur.val;

            if (map.containsKey(sum)) {
                ListNode old = map.get(sum);
                ListNode toRemove = old.next;
                int toRemoveSum = sum;

                while (toRemove != cur) {
                    toRemoveSum += toRemove.val;
                    map.remove(toRemoveSum);
                    toRemove = toRemove.next;
                }

                old.next = cur.next;
            }

            else {
                map.put(sum, cur);
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}