class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c)
            return nums;
        
        int index = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = getNext(nums, index);
                index++;
            }
        }
        return result;
    }
    
    private int getNext(int[][] nums, int index) {
        int row = index / nums[0].length;
        int col = index % nums[0].length;
        
        return nums[row][col];
    }
}