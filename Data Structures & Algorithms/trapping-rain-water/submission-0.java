class Solution {
    public int trap(int[] height) {
        int ans = 0;
        
        int[] leftArr = new int[height.length];
        int[] rightArr = new int[height.length];
        int maxL = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            maxL = Math.max(maxL, height[i]);
            leftArr[i] = maxL;

            int j = height.length - i - 1;
            maxR = Math.max(maxR, height[j]);
            rightArr[j] = maxR;
        }

        int min;
        int water;
        for (int i = 0; i < height.length; i++) {
            min = Math.min(leftArr[i], rightArr[i]);

            water = min - height[i];
            ans += water;
        }

        return ans;
    }
}