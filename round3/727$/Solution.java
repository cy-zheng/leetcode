/*
    dp[i][j] stores the starting index of the substring where T has length i and S has length j.

    So dp[i][j] would be:
    if T[i - 1] == S[j - 1], this means we could borrow the start index from dp[i - 1][j - 1] to make the current substring valid;
    else, we only need to borrow the start index from dp[i][j - 1] which could either exist or not.

    Finally, go through the last row to find the substring with min length and appears first.

    So nice Solution! I rewrite it in my own understanding with comments, I hope it helps.
    figuring out what dp[i][j] means is keypoint:
    dp[i][j] means: for S(0~i) & T(0~j), the "largest" starting index in S which matches T. I think share2017 didn't say largest explicitly, some friends got confused in the comments for this. Since its the largest starting index, so for String T with length 1, if it matches S(i), it should be index i.
    In my solution, I didn't use +1 trick, maybe it's easier to understand @share2017 idea. Thanks!
*/

class Solution {
    public String minWindow(String S, String T) {
        int[][] M = new int[S.length()][T.length()];
        for(int i = 0; i < S.length(); i ++){
            if(S.charAt(i) == T.charAt(0)){
                M[i][0] = i;        //  largest starting index matches only first char in T
            }else{
                if(i == 0){
                    M[i][0] = -1;    // S, T both have 1 char, if !match, fill -1 means we can't find a substring for S(0) & T(0)
                }else{
                    M[i][0] = M[i - 1][0];
                }
            }
        }
        for(int j = 1; j < T.length(); j ++){
            for(int i = 0; i < S.length(); i ++){
                if(S.charAt(i) == T.charAt(j)){
                    if(i == 0){
                        M[i][j] = -1;       //  Actually, if j > i, M[i][j] is always -1, cause we cant find a substring of a shorter string matches a longer string
                    }else{
                        M[i][j] = M[i - 1][j - 1];  // As share2017 mentioned in his post
                    }
                }else{
                    if(i == 0){
                        M[i][j] = -1;
                    }else{
                        M[i][j] = M[i - 1][j];
                    }
                }
            }
        }
        int start = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < S.length(); i ++){
            if(M[i][T.length() - 1] != -1){
                if(i - M[i][T.length() - 1] + 1 < len){
                    len = i - M[i][T.length() - 1] + 1;
                    start = M[i][T.length() - 1];
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : S.substring(start, start + len);
    }
}
