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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();

        for (int n: nums) {
            set.add(n);
        }

        ListNode answer = null;
        ListNode cur = null;

        while (head != null) {
            if (!set.contains(head.val)) {
                if (answer == null) {
                    answer = head;
                } 
                
                else {
                    cur.next = head;
                }

                cur = head;
            }

            head = head.next;
        }

        cur.next = null;

        return answer;
    }
}