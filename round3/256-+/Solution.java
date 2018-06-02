class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int[][] dp = new int[2][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                dp[i % 2][j] = Integer.MAX_VALUE;
                for (int k = 0; k < costs[i].length; k++) {
                    if (j == k)
                        continue;
                    dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][k] + costs[i][j]);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            result = Math.min(result, dp[(costs.length - 1) % 2][i]);
        }
        
        return result;
    }
}
