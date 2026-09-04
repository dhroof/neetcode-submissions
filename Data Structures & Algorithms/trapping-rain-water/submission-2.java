class Solution {
    public int trap(int[] height) {
        int ans = 0;

        int lMax = 0;
        int rMax = 0;

        int ptr1 = 0;
        int ptr2 = height.length - 1;

        while (ptr1 < ptr2) {
            lMax = Math.max(lMax, height[ptr1]);
            rMax = Math.max(rMax, height[ptr2]);

            if (lMax <= rMax) {
                ans += (lMax - height[ptr1]);
                ptr1++;
            } else {
                ans += (rMax - height[ptr2]);
                ptr2--;
            }
        }

        return ans;
    }
}

// [0,2,0,3,1,0,1,3,2,1]
// 0 + 2 + 0 + 0 + 2 + 3 + 2