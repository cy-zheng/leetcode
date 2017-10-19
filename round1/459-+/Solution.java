class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0)
            return true;
        int n = s.length();
        int step = 1;
        while (step < n) {
            if (isRepeated(s, step))
                return true;
            step++;
            while (n % step != 0)
                step++;
        }
        return false;
    }
    
    private boolean isRepeated(String s, int step) {
        String pattern = s.substring(0, step);           // s.substring(step) 是第step个元素开始的子串。substring(int beginIndex)
        for (int i = step; i < s.length(); i++) {
            if (s.charAt(i) != pattern.charAt(i % step))
                return false;
        }
        return true;
    }
}