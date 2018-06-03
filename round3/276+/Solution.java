/*
    dp[i % 3] = dp[(i - 1) % 3] * k - (dp[(i - 1) % 3] - dp[(i - 2) % 3] * (k - 1));
    解释一下，dp[(i - 1) % 3] * k意味着第i位随便选的排列总数
    需要从这个数字中减去会导致连续三位相同的排列数
    导致连续三位相同的排列数 = 前两位相同的排列数 = 前两位总排列数 - 前两位不同的排列数
    = 第二位排列数 - 第一位排列数 * (k - 1) = dp[(i - 1) % 3] - dp[(i - 2) % 3] * (k - 1)
*/

class Solution {
    public int numWays(int n, int k) {
        int[] dp = new int[3];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] * k - (dp[(i - 1) % 3] - dp[(i - 2) % 3] * (k - 1));
        }
        return dp[n % 3];
    }
}
