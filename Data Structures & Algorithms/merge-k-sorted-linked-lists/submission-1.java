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

    private ListNode mergeLinkedList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);

        ListNode ptr = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }

            ptr = ptr.next;
        }

        if (l1 != null) {
            ptr.next = l1;
        } 

        if (l2 != null) {
            ptr.next = l2;
        }

        return head.next;
    }

    private ListNode mergeLists(ListNode lists[], int start, int end) {
        if (start == end) {
            return lists[end];
        }

        int mid = start + (end - start) / 2;

        ListNode left = mergeLists(lists, start, mid);
        ListNode right = mergeLists(lists, mid + 1, end);

        return mergeLinkedList(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeLists(lists, 0, lists.length - 1);
    }
}
