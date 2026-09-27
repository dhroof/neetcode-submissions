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
    public boolean hasCycle(ListNode head) {
        ListNode ptr = head;
        HashMap<ListNode, Boolean> map = new HashMap<>();

        while (ptr != null) {
            if (map.containsKey(ptr)) {
                return true;
            }

            map.put(ptr, true);
            ptr = ptr.next;
        }

        return false;
    }
}
