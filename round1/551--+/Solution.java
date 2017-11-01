/*
    注意要连续3个L才返回False
*/

class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() == 0)
            return true;
        
        int x = 0, y = 0, index = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (x > 1 || y > 2)
                return false;
            if (s.charAt(i) == 'A')
                x++;
            else if (s.charAt(i) == 'L') {
                if (i - 1 == index)
                    y++;
                else 
                    y = 1;
                index = i;
            }
        }
        
        return x <= 1 && y <= 2;
    }
}