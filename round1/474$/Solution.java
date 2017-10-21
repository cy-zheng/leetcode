/*
    http://bookshadow.com/weblog/2016/12/11/leetcode-ones-and-zeroes/
*/

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];   // dp[i][j] 表示在i个0，j个1时，所能取到的最大个数
        for (String s : strs) {
            int zero = 0, one = 0;            // 统计0、1个数
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = m; i > zero - 1; i--) {      // 只遍历可以包含当前字符串s的区间，--遍历是因为小的状态要使用到，小的状态不能包含当前字符串
                for (int j = n; j > one - 1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}