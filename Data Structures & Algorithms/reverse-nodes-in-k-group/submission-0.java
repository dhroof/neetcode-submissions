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
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = end.next;

        while (start != end) {
            ListNode temp = start.next;
            start.next = prev;
            prev = start;
            start = temp;
        }

        start.next = prev;

        return start;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;

        while (end != null) {
            if (count == k) {
                ListNode temp = start.next;
                start.next = reverse(start.next, end);
                start = temp;
                end = start;
                count = 0;
                continue;
            }

            end = end.next;
            count++;
        }

        return dummy.next;
    }
}
