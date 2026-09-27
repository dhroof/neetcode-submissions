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
    private ListNode reverseList(ListNode head) {
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

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = getMiddleNode(head);

        ListNode ptr1 = head;
        ListNode ptr2 = reverseList(mid.next);
        mid.next = null;


        while (ptr2 != null) {
            ListNode temp1 = ptr1.next;
            ListNode temp2 = ptr2.next;

            ptr1.next = ptr2;
            ptr2.next = temp1;

            ptr1 = temp1;
            ptr2 = temp2;
        }
    }
}
