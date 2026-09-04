class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;

        int ptr1 = 0;
        int ptr2 = 1;
        while (ptr1 < ptr2 && ptr2 < prices.length) {
            while (ptr1 < ptr2 && ptr2 < prices.length && prices[ptr2] >= prices[ptr1]) {
                ans = Math.max(ans, prices[ptr2] - prices[ptr1]);
                ptr2++;
            }

            ptr1 = ptr2;
            ptr2++;
        }

        return ans;
    }
}