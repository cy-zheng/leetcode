class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }
    
    private boolean check(String s, int start, int count) { // startIndex， count是左括号的数量
        if (count < 0) return false;
        
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                if (count <= 0) return false;
                count--;
            }
            else if (c == '*') {
                return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
            }
        }
        
        return count == 0;
    }
}
