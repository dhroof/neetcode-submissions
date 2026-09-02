class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {0, 0};

        int ptr1 = 0;
        int ptr2 = numbers.length - 1;

        while (ptr1 <= ptr2) {
            if (numbers[ptr1] + numbers[ptr2] == target) {
                ans[0] = ptr1 + 1;
                ans[1] = ptr2 + 1;
                return ans;
            }

            // Move ptr 2 to right if target is smaller
            if (numbers[ptr1] + numbers[ptr2] >= target) {
                ptr2--;
                continue;
            }

            // Move ptr 1 to left if target is greater
            if (numbers[ptr1] + numbers[ptr2] <= target) {
                ptr1++;
                continue;
            }

            break;
        }

        return ans;
    }
}
