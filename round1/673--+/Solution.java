/*
    相当于使用count数组记录前面达到这个长度的路径条数
*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int max = 1, result = 0;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i])
                        count[i] += count[j];
                    else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max)
                result += count[i];
        }
        return result;
    }
}
