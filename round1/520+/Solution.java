class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 1)
            return true;
        if (isCapital(word.charAt(0))) {
            if (isCapital(word.charAt(word.length() - 1))) {
                for (int i = 0; i < word.length(); i++) {
                    if (!isCapital(word.charAt(i)))
                        return false;
                }
                return true;
            }
            else {
                for (int i = 1; i < word.length(); i++) {
                    if (isCapital(word.charAt(i)))
                        return false;
                }
                return true;
            }
        }
        else {
            for (int i = 0; i < word.length(); i++) {
                if (isCapital(word.charAt(i)))
                    return false;
            }
            return true;
        }
    }
    
    private boolean isCapital(char c) {
        if (c >= 'A' && c <= 'Z')
            return true;
        return false;
    }
}
