class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;

        int sum = 0;
        int ptr1 = 0;
        for (int ptr2 = 0; ptr2 < nums.length; ptr2++) {
            sum += nums[ptr2];
            while (sum >= target) {
                ans = Math.min(ans, ptr2 - ptr1 + 1);
                sum -= nums[ptr1++];
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
}