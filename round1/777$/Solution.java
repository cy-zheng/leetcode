/*
    解释很赞：
    https://blog.csdn.net/u014688145/article/details/79254178
*/

class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length())
            return false;
        
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') 
                i += 1;
            while (j < n && end.charAt(j) == 'X')
                j += 1;
            
            if (i == n && j == n)
                break;
            if (i == n || j == n || start.charAt(i) != end.charAt(j))
                return false;
            if (start.charAt(i) == 'L' && i < j)
                return false;
            if (start.charAt(i) == 'R' && i > j)
                return false;
            i += 1;
            j += 1;
        }
        return true;
    }
}
