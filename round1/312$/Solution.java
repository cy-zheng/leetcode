/*
    区间型dp经典题目
    要遍历最后爆炸的气球，如果遍历第一个爆炸的气球，那么剩下的气球相邻关系会有变化，存储没有太大的意义
    然而，最后爆炸的气球，左右两边是重复的子问题，是不受最后爆炸气球的影响的
*/

class Solution {
    public int maxCoins(int[] iNums) {
        int n = iNums.length;
        int[] nums = new int[n + 2];
        for (int i = 0; i < n; i++) nums[i + 1] = iNums[i];
        nums[0] = nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        // dp[i][j]的含义是引爆i~j的气球，获得的最大的金币数
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n - k + 1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][x - 1] + nums[i - 1] * nums[x] * nums[j + 1] + dp[x + 1][j]);
                    /*  
                        dp[i][x - 1] + nums[i - 1] * nums[x] * nums[j + 1] + dp[x + 1][j] 的含义是：
                        x是最后爆炸的气球，dp[i][x - 1]是左边的最大值，dp[x + 1][j]是右边的最大值
                        nums[i - 1] * nums[x] * nums[j + 1]是左右都爆炸了，引爆x和i~j区间外边的两个气球
                    */
                }
            }
        }
        return dp[1][n];
    }
}