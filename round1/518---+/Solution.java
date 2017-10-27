/*
    背包问题，注意在amount = 0时返回1
*/

class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        if (coins == null || coins.length == 0)
            return 0;
        
        int[][] dp = new int[2][amount + 1];
        
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] > j)
                    dp[i % 2][j] = dp[(i + 1) % 2][j];
                else {
                    if (coins[i] == j) {
                        dp[i % 2][j] = dp[(i + 1) % 2][j] + 1;
                    }
                    else {
                        dp[i % 2][j] = dp[(i + 1) % 2][j] + dp[i % 2][j - coins[i]];
                    }
                }
            }
        }
        
        return dp[(coins.length - 1) % 2][amount];
    }
}
