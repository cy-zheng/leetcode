/*
    dp问题，i~j是否是回文串可以由i+1~j-1，i==j判断出来。
*/

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        
        // initialize
        int n = s.length();
        int max = 1;
        String result = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        
        // traverse dp matrix
        for (int j = 0; j < n; j++){
            for (int i = 0; i < j; i++){
                if (s.charAt(i) == s.charAt(j)){
                    if (i + 1 == j){
                        if (max < 2){
                            max = 2;
                            result = s.substring(i, j + 1);
                        }
                        dp[i][j] = true;
                    }
                    else if (dp[i + 1][j - 1]){
                        if (max < j - i + 1){
                            max = j - i + 1;
                            result = s.substring(i, j + 1);
                        }
                        dp[i][j] = true;
                    }
                }
            }
        }
        if (max == 1){
            return s.substring(0, 1);
        }
        return result;
    }
}