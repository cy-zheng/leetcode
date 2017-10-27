/*
    dp[i][j] = dp[i + 1][j - 1] + 2           if s[i] == s[j]
    dp[i][j] = max(dp[i][j - 1], dp[i + 1][j])    otherwise
    
    可以这样理解状态转移方程：
    一开始dp[i][i]的值都为1，如果当前i和j所指元素相等，说明能够加到i～j的回文子串的长度中，所以更新dp[i][j] = dp[i+1][j-1] + 2; 如果当前元素不相等，那么说明这两个i、j所指元素对回文串无贡献，则dp[i][j]就是从dp[i+1][j]和dp[i][j-1]中选取较大的一个值即可
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][s.length() - 1];
    }
}
