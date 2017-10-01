/*
    注意乘法溢出
*/

class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0)
            return 0;
        long left = 1, right = n;
        while (left + 1 < right) {
            long mid = (right - left) / 2 + left;
            if (mid * (mid + 1) / 2 <= n)
                left = mid;
            else
                right = mid;
        }
        if (right * (right + 1) / 2 <= n)
            return (int) right;
        return (int) left;
    }
}