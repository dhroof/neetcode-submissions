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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode ptr = head;
        ListNode prevNode = null;
        
        while (ptr.next != null) {
            ListNode nextNode = ptr.next;
            ptr.next = prevNode;
            prevNode = ptr;
            ptr = nextNode;
        }

        ptr.next = prevNode;

        return ptr;
    }
}
