class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 3)
            return 0;
        int[] dp = new int[3];
        for (int i = 2; i <= cost.length; i++)
            dp[i % 3] = Math.min(dp[(i - 2) % 3] + cost[i - 2], dp[(i - 1) % 3] + cost[i - 1]);
        
        return dp[cost.length % 3];
    }
}
