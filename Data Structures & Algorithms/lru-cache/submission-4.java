class Node {
    public Node next;
    public Node prev;
    public int key;
    public int val;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    public Node head;
    public Node tail;
    public int size;
    public int nodeCount;
    public HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.nodeCount = 0;
        this.head = null;
        this.tail = null;
        map = new HashMap<>();
    }

    private Node remove(int key) {
        Node node = map.get(key);

        if (node == null) {
            return null;
        }

        if (this.nodeCount == 1) {
            this.head = null;
            this.tail = null;
        } else if (node == this.head) {
            this.head.next.prev = null;
            this.head = this.head.next;
        } else if (node == this.tail) {
            node.prev.next = null;
            this.tail = this.tail.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = null;
        node.prev = null;
        map.remove(key);
        this.nodeCount--;

        return node;
    }

    private void append(Node node) {
        if (node == null) {
            return;
        }

        Node tempNode1 = map.get(node.key);
        if (tempNode1 != null) {
            Node tempNode2 = remove(node.key);
        }

        if (nodeCount == size) {
            Node tempNode = remove(this.head.key);
        }

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }

        map.put(node.key, node);
        this.nodeCount++;
    }

    public int get(int key) {
        Node node = remove(key);

        if (node == null) {
            return -1;
        }

        append(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);

        Node existingNode = map.get(node.key);
        if (existingNode != null) {
            remove(node.key);
        }

        if (nodeCount == size) {
            remove(this.head.key);
        }

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
        }

        map.put(node.key, node);
        this.nodeCount++;
    }
}
