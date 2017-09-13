/*
    元素可以重复使用的背包类dp
*/

class Solution {
    public int integerBreak(int n) {
        if (n == 1 || n == 2) return 1;
        int result = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i)
                    dp[i][j] = dp[i - 1][j];
                else if (j == i)
                    dp[i][j] = i + 1;
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - i - 1] * (i + 1));
                }
            }
        }
        
        for (int i = 0; i < n - 1; i++)
            result = Math.max(result, dp[i][n - 1]);
        
        return result;
    }
}

/*
    Hint说可以用O(n)的方法，找7-10的规律
    数字7拆为3+4，乘积最大，为12。
    数字8拆为3+3+2，乘积最大，为18。
    数字9拆为3+3+3，乘积最大，为27。
    数字10拆为3+3+4，乘积最大，为36。
    
    可以看出从5开始，数字都需要先拆出所有的3，一直拆到剩下一个数为2或者4，因为剩4就不用再拆了，拆成两个2和不拆没有意义，而且4不能拆出一个3剩一个1，这样会比拆成2+2的乘积小。
*/

class Solution {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}