class Solution {
    public boolean isStrobogrammatic(String s) {
        if (s == null | s.length() == 0)
            return true;
        
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (i == j) {
                return s.charAt(i) == '8' && s.charAt(i) == '8' || s.charAt(i) == '1' && s.charAt(i) == '1'
                    || s.charAt(i) == '0' && s.charAt(i) == '0';
            }
            char left = s.charAt(i), right = s.charAt(j);
            if (left == '6' && right == '9') {
                i += 1;
                j -= 1;
            }
            else if (left == '9' && right == '6') {
                i += 1;
                j -= 1;
            }
            else if (left == '8' && right == '8') {
                i += 1;
                j -= 1;
            }
            else if (left == '1' && right == '1') {
                i += 1;
                j -= 1;
            }
            else if (left == '0' && right == '0') {
                i += 1;
                j -= 1;
            }
            else
                return false;
        }
        return true;
    }
}
