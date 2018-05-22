class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int[] left = new int[grid.length];
        int[] down = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                left[i] = Math.max(left[i], grid[i][j]);
                down[j] = Math.max(down[j], grid[i][j]);
            }
        }
        
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result += Math.min(left[i], down[j]) - grid[i][j];
            }
        }
        return result;
    }
}
