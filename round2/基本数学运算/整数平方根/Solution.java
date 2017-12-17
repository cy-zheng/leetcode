/*
    leetcode 69
*/

class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int left = 1, right = x;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            // 注意mid * mid本身还是int型的，可能会溢出，转为long
            if (1L * mid * mid >= x)
                right = mid;
            else
                left = mid;
        }
        
        if (1L * right * right <= x)
            return right;
        return left;
    }
}
