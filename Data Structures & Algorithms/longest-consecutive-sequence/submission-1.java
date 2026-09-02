class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // Left exists - not starting of the sequence
            if (map.getOrDefault(nums[i] - 1, false) == true) {
                continue;
            }

            int continous = 0;
            int val = nums[i];
            while (map.getOrDefault(val, false) == true) {
                continous++;
                val++;
            }

            ans = Math.max(ans, continous);
        }

        return ans;
    }
}
