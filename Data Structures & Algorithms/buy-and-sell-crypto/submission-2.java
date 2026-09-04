class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minVal = Math.min(minVal, prices[i]);
            ans = Math.max(ans, prices[i] - minVal);
        }

        return ans;
    }
}