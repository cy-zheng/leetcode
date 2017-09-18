/*
    几个模运算性质：
    (a + b) % p = (a % p + b % p) % p
    (a * b) % p = (a % p * b % p) % p 
    a ^ b % p = ((a % p)^b) % p 
     
    参考http://www.cnblogs.com/grandyang/p/5651982.html
    1、在计算幂运算时，将幂次对半缩小
    2、切记在所有有可能溢出的地方做一次模运算
    3、对于b是一个数组的情况，用2^23 = (2^2)^10 * 2^3的思想解
*/

class Solution {
    public int superPow(int a, int[] b) {
        int result = 1;
        for (int num : b) {
            result = pow(result, 10) * pow(a, num) % 1337;
        }
        return result;
    }
    
    private int pow(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x % 1337;
        int half = pow(x % 1337, n / 2);
        if (n % 2 == 0)
            return (half * half) % 1337;
        else
            return (half * half % 1337) * (x % 1337) % 1337;
    }
}