class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftArr = new int[nums.length + 2];
        leftArr[0] = 1;
        leftArr[leftArr.length - 1] = 1;

        int[] rightArr = new int[nums.length + 2];
        rightArr[0] = 1;
        rightArr[rightArr.length - 1] = 1;

        int leftProd = 1;
        int rightProd = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            leftProd *= nums[i];
            leftArr[i + 1] = leftProd;

            rightProd *= nums[j];
            rightArr[j + 1] = rightProd;
        }

        int[] ans = new int[nums.length];

        int ptr = 0;
        for (int i = 0; i < leftArr.length - 2; i++) {
            ans[ptr++] = leftArr[i] * rightArr[i + 2];
        }

        return ans;
    }
}

//  Left [1,  1,  2,  8, 48, 1]
// Right [1, 48, 48, 24,  6, 1]
// Ans      [48, 24, 12,  8]