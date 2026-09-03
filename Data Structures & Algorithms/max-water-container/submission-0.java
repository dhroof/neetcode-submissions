class Solution {
    public int maxArea(int[] heights) {
        int ans = 0;

        int ptrL = 0;
        int ptrR = heights.length - 1;
        int area = 0;
        int minH = 0;

        while (ptrL < ptrR) {
            minH = Math.min(heights[ptrL], heights[ptrR]);
            area = minH * (ptrR - ptrL);
            ans = Math.max(ans, area);

            if (heights[ptrL] > heights[ptrR]) {
                ptrR--;
            } else {
                ptrL++;
            }
        }

        return ans;
    }
}
