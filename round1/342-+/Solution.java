/*
    判断num是不是4的幂（不是4的倍数）
    num >= 0才有可能是true
    => 只有一个bit为1，后缀0有偶数个
*/

class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        return Integer.bitCount(num) == 1 && findTailZero(num) % 2 == 0;
    }
    
    private int findTailZero(int num) {
        int result = 0;
        int shift = 0;
        while ((num & (1 << shift)) == 0) {
            result++;
            shift++;
        }
        return result;
    }
}