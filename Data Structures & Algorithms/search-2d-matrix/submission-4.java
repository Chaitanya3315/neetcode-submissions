class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Binary search to find the correct row
        int l = 0, r = m;
        while (l < r) {
            int mid = (l + r) / 2;
            if (matrix[mid][0] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int row = l - 1;
        if (row < 0) return false;  // Edge case: target is smaller than the first element

        // Binary search within the identified row
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
