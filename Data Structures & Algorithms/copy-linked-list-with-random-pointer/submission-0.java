/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        HashMap<Node, Node> map = new HashMap<>();

        Node ptr = head;
        while (ptr != null) {
            if (map.containsKey(ptr)) {
                continue;
            }

            Node node = new Node(ptr.val);
            map.put(ptr, node);
            ptr = ptr.next;
        }

        ptr = head;
        while (ptr != null) {
            Node ptr2 = map.get(ptr);

            ptr2.next = map.get(ptr.next);
            if (ptr.random != null) {
                ptr2.random = map.get(ptr.random);
            }

            ptr = ptr.next;
        }

        return map.get(head);
    }
}
