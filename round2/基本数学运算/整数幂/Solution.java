/*
    leetcode 50
*/
class Solution {
    public double myPow(double x, long n) {
        // 任何数的0次幂都是1
        if(n == 0)
            return 1;
        // 让n > 0
        // 注意如果n是int，n = -n会导致溢出
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        // 思路在于2^4 = 4^2
        // 2^4 = 2 * 2 * 2 * 2
        // 4^2 = 2 * 2 -> 4, 4 * 4，减少了计算
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
