/*
    leetcode 319
    任何数的因数都是偶数个，除了完全平方数
    所以开着的灯泡个数=小于n的完全平方数
*/

public class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
