class Solution {
    public int maxA(int n) {
        // dp存储第i步能得到的最大字符串长度
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;  // 至少为i
            // 对于i - 3之前的j，可以copy，因为ctrl+a ctrl+c至少2步
            // 在copy完之后，可以粘贴i - j - 1次
            for (int j = 1; j < i - 2; j++)
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        return dp[n];
    }
}
