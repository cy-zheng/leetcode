/*
    leetcode 322
    无限背包问题
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        int[][] dp = new int[amount + 1][coins.length];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j > 0)
                    dp[i][j] = dp[i][j - 1];
                else
                    dp[i][j] = Integer.MAX_VALUE;
                
                if (coins[j] <= i && dp[i - coins[j]][j] != Integer.MAX_VALUE) 
                    dp[i][j] = Math.min(dp[i][j], dp[i - coins[j]][j] + 1);
            }
        }
        return dp[amount][coins.length - 1] == Integer.MAX_VALUE ? -1 : dp[amount][coins.length - 1];
    }
}
