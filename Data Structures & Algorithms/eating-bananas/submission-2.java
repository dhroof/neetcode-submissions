class Solution {
    private int findTotalHours(int[] arr, int k) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += Math.ceil((double) arr[i] / k);
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]);
        }
        
        int start = 1;
        int end = maxPile;
        int ans = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int totalHours = findTotalHours(piles, mid);

            if (totalHours > h) {
                start = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
        }

        return ans;
    }
}
