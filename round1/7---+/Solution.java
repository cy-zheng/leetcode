/*
    ��Խ��������ص���Ŀ���ڲ���������long
    Math.pow()����double�����о�����ʧ
*/

public class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        boolean isPositive = x >= 0;
        long y = Math.abs((long)x);
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
        if (isPositive && result > Integer.MAX_VALUE){
            return 0;
        }
        if (!isPositive && result > Integer.MAX_VALUE + 1L){
            return 0;
        }
        if (isPositive) return (int)result;
        return (int)-result;
    }
}