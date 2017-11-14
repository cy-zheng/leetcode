/*
    单序列dp
*/

class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n];
        for (int i = 1; i < dp.length; i++)
            dp[i] = i + 1;
        
        for (int i = 1; i < dp.length; i++) {
            int step = 1;
            for (int j = 2 * i + 1; j < dp.length; j += i + 1) {
                step++;
                dp[j] = Math.min(dp[j], dp[i] + step);
            }
        }
        
        return dp[n - 1];
    }
}