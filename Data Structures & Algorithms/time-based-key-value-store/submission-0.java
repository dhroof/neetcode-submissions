class TimeMap {
    private static class Node {
        int timestamp;
        String value;

        Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private HashMap<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Node node = new Node(timestamp, value);

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        List<Node> list = map.get(key);
        list.add(node);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Node> list = map.get(key);

        int start = 0;
        int end = list.size() - 1;
        int mid;
        int candidate = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                candidate = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (candidate == -1) {
            return "";
        }

        return list.get(candidate).value;
    }
}
