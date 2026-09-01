class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Integer n : map.keySet()) {
            int freq = map.get(n);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(n);
        }

        int ans[] = new int[k];
        int counter = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (k == counter) {
                break;
            }
            if (buckets[i] == null) {
                continue;
            }
            for (Integer j : buckets[i]) {
                ans[counter] = j;
                counter++;
            }
        }

        return ans;
    }
}
