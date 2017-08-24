/*
    先用n^2的dp计算任意两个点是不是回文串
    再用一个单序列dp
*/

class Solution {
    
    private boolean[][] dp;
    
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        checkPalindrome(s);
        int[] cache = new int[s.length()];
        for (int i = 1; i < cache.length; i++) {
            cache[i] = cache[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j][i]) {
                    cache[i] = j == 0 ? 0 : Math.min(cache[i], cache[j - 1] + 1);
                }
            }
        }
        return cache[cache.length - 1];
    }
    
    public void checkPalindrome(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        
        // traverse dp matrix
        for (int j = 0; j < n; j++){
            for (int i = 0; i < j; i++){
                if (s.charAt(i) == s.charAt(j)){
                    if (i + 1 == j){
                        dp[i][j] = true;
                    }
                    else if (dp[i + 1][j - 1]){
                        dp[i][j] = true;
                    }
                }
            }
        }
    }
}