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
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        ListNode bot = new ListNode(head.val);
        
        while (cur.next != null) {
            cur = cur.next;
            ListNode tmp = new ListNode(cur.val);
            tmp.next = bot;
            bot = tmp;
        }

        while (bot.next != null && head.next != null) {
            if (bot.val != head.val) return false;
            bot = bot.next;
            head = head.next;
        }

        return true;
    }
}