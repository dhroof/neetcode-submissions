class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int ptr1 = i + 1;
            int ptr2 = nums.length - 1;

            while (ptr1 < ptr2) {
                int sum = nums[i] + nums[ptr1] + nums[ptr2];

                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[ptr1], nums[ptr2]));
                    ptr1++;
                    ptr2--;

                    // Skip duplicate values for ptr1 and ptr2
                    while (ptr1 < ptr2 && nums[ptr1] == nums[ptr1 - 1]) ptr1++;
                    while (ptr1 < ptr2 && nums[ptr2] == nums[ptr2 + 1]) ptr2--;
                }

                if (sum > 0) {
                    ptr2--;
                }

                if (sum < 0) {
                    ptr1++;
                }
            }
        }

        return ans;
    }
}

// [-4, -1, -1, 0, 1, 2]