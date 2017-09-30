/*
    有限背包问题，数组中是否存在子集，和为n / 2
*/

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] > j)
                    dp[i + 1][j] = dp[i][j];
                else 
                    dp[i + 1][j] = dp[i][j - nums[i]] || dp[i][j];      // 注意这里不要忘了后面的dp[i][j]，代表当前元素不放入背包
            }
        }
        return dp[nums.length][target];
    }
}