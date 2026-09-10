class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1; // Minimum is in the right unsorted portion
            } else {
                end = mid; // mid could be the minimum, keep it in range
            }
        }

        return nums[start];
    }
}
