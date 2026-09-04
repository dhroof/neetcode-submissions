class Solution {
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int lMin = Integer.MAX_VALUE;
        int rMax = 0;
        int j = prices.length - 1;
        for (int i = 0; i < prices.length; i++) {
            lMin = Math.min(lMin, prices[i]);
            left[i] = lMin;

            rMax = Math.max(rMax, prices[j - i]);
            right[j - i] = rMax;
        }

        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, right[i] - left[i]);
        }
        return ans;
    }
}

// [7,1,5,3,6,4]
// [7,1,1,1,1,1]
// [7,6,6,6,6,4]

// [1,2]

// [1,1]
// [2,2]