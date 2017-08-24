/*
    只考虑数字和字母，不考虑大小写
*/


class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if ((s.charAt(left) < 'a' || s.charAt(left) > 'z') && (s.charAt(left) < '0' || s.charAt(left) > '9')) {
                left++;
                continue;
            }
            if ((s.charAt(right) < 'a' || s.charAt(right) > 'z') && (s.charAt(right) < '0' || s.charAt(right) > '9')) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}