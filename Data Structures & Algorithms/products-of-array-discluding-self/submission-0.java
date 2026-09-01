class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> leftArr = new ArrayList<>();
        leftArr.add(1);
        List<Integer> rightArr = new ArrayList<>();
        rightArr.add(1);

        int leftProd = 1;
        int rightProd = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            leftProd *= nums[i];
            leftArr.add(leftProd);

            rightProd *= nums[j];
            rightArr.add(1, rightProd);
        }
        leftArr.add(1);
        rightArr.add(1);

        int[] ans = new int[nums.length];

        int ptr = 0;
        for (int i = 0; i < leftArr.size() - 2; i++) {
            ans[ptr++] = leftArr.get(i) * rightArr.get(i + 2);
        }

        return ans;
    }
}

//  Left [1,  1,  2,  8, 48, 1]
// Right [1, 48, 48, 24,  6, 1]
// Ans      [48, 24, 12,  8]