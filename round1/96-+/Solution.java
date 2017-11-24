/*
    比如求解n = 5，那么可以看成 左子树0 * 右子树4 + 左子树1 * 右子树3 + 2 * 2 + 3 * 1 + 4 * 0。。。的次数
*/

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int j = 0, k = i - 1;
            while (j < i && k >= 0) {
                dp[i] += dp[j] * dp[k];
                j++;
                k--;
            }
        }
        return dp[n];
    }
}