class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        boolean isUp = true;
        int i = 0, j = 0;
        while (true) {
            result[index] = matrix[i][j];
            boolean hasNext = false;
            if (isUp) {
                if (i - 1 >= 0 && j + 1 < matrix[0].length) {
                    i--;
                    j++;
                    hasNext = true;
                }
                else if (j + 1 < matrix[0].length) {
                    j++;
                    hasNext = true;
                    isUp = !isUp;
                }    
                else if (i + 1 < matrix.length) {
                    i++;
                    hasNext = true;
                    isUp = !isUp;
                }
            }
            else {
                if (j - 1 >= 0 && i + 1 < matrix.length) {
                    j--;
                    i++;
                    hasNext = true;
                }
                else if (i + 1 < matrix.length) {
                    i++;
                    hasNext = true;
                    isUp = !isUp;
                }    
                else if (j + 1 < matrix[0].length) {
                    j++;
                    hasNext = true;
                    isUp = !isUp;
                }
            }
            if (!hasNext)
                break;
            index++;
        }
        return result;
    }
}