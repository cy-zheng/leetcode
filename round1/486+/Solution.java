/*
    博弈类dp
*/

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i][i] = nums[i];
            if (i != nums.length - 1) 
                dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }
        
        for (int step = 2; step < nums.length; step++) {
            for (int i = 0; i < nums.length - step; i++) {
                dp[i][i + step] = Math.max(nums[i] + Math.min(dp[i + 2][i + step], dp[i + 1][i + step - 1]), 
                                           nums[i + step] + Math.min(dp[i + 1][i + step - 1], dp[i][i + step - 2]));
            }
        }
        
        return dp[0][nums.length - 1] >= (sum + 1) / 2;
    }
}