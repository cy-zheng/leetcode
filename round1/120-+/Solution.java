/*
    dp，滚动数组优化
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        int[][] dp = new int[2][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[(triangle.size() - 1) % 2][i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i % 2][j] = triangle.get(i).get(j) + Math.min(dp[(i + 1) % 2][j], dp[(i + 1) % 2][j + 1]);    
            }
        }
        return dp[0][0];
    }
}