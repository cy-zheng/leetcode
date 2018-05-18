/*
    注意除了判断第一行，还要判断第一列
    注意数组下标越界
*/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return true;
        
        for (int j = matrix[0].length - 1; j >= 0; j--) {
            if (!isSame(matrix, 0, j))
                return false;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (!isSame(matrix, i, 0))
                return false;
        }
        
        return true;
    }
    
    private boolean isSame(int[][] matrix, int i, int j) {
        int target = matrix[i][j];
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] != target)
                return false;
            i++;
            j++;
        }
        return true;
    }
}
