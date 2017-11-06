/*
    比如已知dp[i][j] = 2，计算i + 1这一行
    新的一个数字可以插入在i + 1个位置，插入在第一个位置，那么相当于后面i个数字都多了一个逆序对
    如果插入在最后，那么之前的数字没有增加任何一个逆序对
    所以dp[i + 1][j + m] += dp[i][j]，m表示插入位置
*/

class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= k; j++) {
                for (int m = 0; m < i + 2; m++) {
                    if (j + m > k)
                        break;
                    dp[i + 1][j + m] += dp[i][j];
                    dp[i + 1][j + m] %= 1000000007;
                }    
            }
        }
        return dp[n - 1][k];
    }
}