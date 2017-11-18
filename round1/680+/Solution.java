class Solution {
    public boolean validPalindrome(String s) {
        if (isPalindrome(s, 0, s.length() - 1))
            return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isPalindrome(String s, int i, int j) {
        if (i >= j)
            return true;
        while (i < j) {
           if (s.charAt(i) != s.charAt(j))
               return false;
            i++;
            j--;
        }
        return true;
    }
}
