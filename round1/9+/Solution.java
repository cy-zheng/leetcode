/* 
    使用第7题思想改的
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        long y = (long)x;
        long result = 0;
        long shift = 1;
        long z = y;
        while (z / 10 > 0) {
            shift *= 10;
            z /= 10;
        }
        for (long i = shift; i > 0; i /= 10){
            result += (y / i) * (shift / i);
            y %= i; 
        }
        if (result > Integer.MAX_VALUE){
            return false;
        }
        return (int)result == x;
    }
}