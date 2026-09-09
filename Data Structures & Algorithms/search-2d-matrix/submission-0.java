class Solution {
    private boolean isPresent(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int ptr1 = matrix[mid][0];
            int ptr2 = matrix[mid][matrix[0].length - 1];

            if (ptr1 <= target && target <= ptr2) {
                return isPresent(matrix[mid], target);
            } else if (ptr2 < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
