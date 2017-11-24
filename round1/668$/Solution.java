/*
    经典的对解空间二分：
    矩阵中所有元素都落在1 ~ m * n区间之内，可以对于每个元素，求解矩阵中有几个小于等于该元素的元素个数。
    这样这个题目就成了一个OOXX类问题，找第一个X元素。
    但是有一点需要额外注意，并不是所有的1 ~ m * n之间的元素都会在矩阵中。
    但是，第一个X一定是在矩阵中的。因为如果X不在矩阵中，那么X - 1一定也会满足count >= k这个条件的。
    所以返回第一个X就可以了。
*/

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int count = count(mid, m, n);
            if (count >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (count(left, m, n) >= k)
            return left;
        return right;
    }

    private int count(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, mid / i);       // 求解矩阵中有几个小于等于该元素的元素个数
        }
        return count;
    }
}