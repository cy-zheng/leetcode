class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
                j += 1;
            } 
            else {
                if (test(s, t, i + 1, j))
                    return true;
                if (test(s, t, i, j + 1))
                    return true;
                if (test(s, t, i + 1, j + 1))
                    return true;
                return false;
            }
        }
        if (i == s.length() && j == t.length())
            return false;
        if (i == s.length() - 1 && j == t.length())
            return true;
        if (i == s.length() && j == t.length() - 1)
            return true;
        return false;
    }
    
    private boolean test(String s, String t, int i, int j) {
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i += 1;
                j += 1;
            } 
            else {
                return false;
            }
        }
        return i == s.length() && j == t.length();
    }
}
