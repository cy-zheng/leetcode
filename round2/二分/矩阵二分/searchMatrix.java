/*
    leetcode 74
    当成一个有序数组绕了几圈即可
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int left = 0, right = matrix.length * matrix[0].length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;
            if (matrix[i][j] < target) 
                left = mid;
            else
                right = mid;
        }
        int i = left / matrix[0].length;
        int j = left % matrix[0].length;
        if (matrix[i][j] == target)
            return true;
        i = right / matrix[0].length;
        j = right % matrix[0].length;
        if (matrix[i][j] == target)
            return true;
        return false;
    }
}
