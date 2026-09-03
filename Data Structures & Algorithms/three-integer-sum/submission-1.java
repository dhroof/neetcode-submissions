class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<List<Integer>, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int ptr1 = i + 1;
            int ptr2 = nums.length - 1;

            while (ptr1 < ptr2) {
                int sum = nums[i] + nums[ptr1] + nums[ptr2];
                List<Integer> tempList = List.of(nums[i], nums[ptr1], nums[ptr2]);

                if (sum == 0) {
                    if (!map.containsKey(tempList)) {
                        ans.add(tempList);
                        map.put(tempList, true);
                    }
                    ptr1++;
                    ptr2--;
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