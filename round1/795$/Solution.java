/*
    双序列dp可以做到O(n^2)
    注意每次计算的是以当前元素为结尾的子串个数
    For example, for input A = [0, 1, 2, -1], L = 2, R = 3:
    for 0, no valid subarray ends at 0;
    for 1, no valid subarray ends at 1;
    for 2, three valid subarrays end at 2, which are [0, 1, 2], [1, 2], [2];
    for -1, the number of valid subarrays is the same as 2, which are [0, 1, 2, -1], [1, 2, -1], [2, -1]
*/

class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        // i, j双指针，count是符合条件的前缀长度（j ~ max element）
        int j = 0, count = 0, res = 0;
        for(int i = 0; i < A.length; i++) {
            // 更新max element位置，从而更新count
            if (A[i] >= L && A[i] <= R)  {
                count = i - j + 1;
                res += count;
            }
            // 当前元素可以继续延长
            else if (A[i] < L) {
                res += count;
            }
            // 重新计算max element
            else {
                j = i + 1;
                count = 0;
            }
        }
        return res;
    }
}
