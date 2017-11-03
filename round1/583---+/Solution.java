/*
    双序列型dp
*/

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return -1;
        if (word1 == null || word1.length() == 0)
            return word2.length();
        if (word2 == null || word2.length() == 0)
            return word1.length();
        
        int[][] dp = new int[2][word2.length() + 1];
        for (int i = 0; i <= word2.length(); i++)
            dp[0][i] = i;
        
        for (int i = 0; i < word1.length(); i++) {
            dp[(i + 1) % 2][0] = i + 1;
            for (int j = 0; j < word2.length(); j++) {
                dp[(i + 1) % 2][j + 1] = Math.min(dp[i % 2][j + 1] + 1, 
                                                  Math.min(dp[(i + 1) % 2][j] + 1, 
                                                          dp[i % 2][j] + (word1.charAt(i) == word2.charAt(j) ? 0 : 2)));
            }
        }
        
        return dp[word1.length() % 2][word2.length()];
    }
}