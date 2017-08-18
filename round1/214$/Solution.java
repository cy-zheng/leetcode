public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String copy = (new StringBuffer(s)).reverse().toString();
        int n = s.length(), i;
        
        for (i = n; i >= 0; i--) {
            if (test(s, copy, i, n - i))
                break;
        }
        
        return (new StringBuffer(s.substring(i))).reverse().toString() + s;
    }
    
    private boolean test(String s1, String s2, int i1, int i2) {
        for (int i = 0; i < i1; i++) {
            if (s1.charAt(i) != s2.charAt(i2 + i))
                return false;
        }
            
        return true;
    }
}