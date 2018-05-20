/*
    双指针判断是否子串
*/

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        for (String word : words) {
            if (isSubsequence(S, word)) {
                result += 1;
            }
        }
        return result;
    }
    
    private boolean isSubsequence(String source, String target) {
        if (target.length() == 0)
            return true;
        if (source.length() == 0)
            return false;
        
        int i = 0, j = 0;
        while (i < source.length() && j < target.length()) {
            if (source.charAt(i) == target.charAt(j)) {
                i += 1;
                j += 1;
            }
            else {
                i += 1;
            }
        }
        return j == target.length();
    }
}
