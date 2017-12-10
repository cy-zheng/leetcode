/*
    以下答案使用二分解空间，时间复杂度O(n^2 * logn)
    然后有一步改进：
    不只是二分解空间，而且在greaterThanK时，也使用二分
    这样时间复杂度就是O(n * logn * logn)
*/

import java.util.*;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (greaterThanK(nums, mid, k))
                right = mid;
            else
                left = mid;
        }
        if (!greaterThanK(nums, right, k))
            return right;
        return left;
    }

    private boolean greaterThanK(int[] nums, int mid, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left + 1 < right) {
                int midInner = (right - left) / 2 + left;
                if (nums[midInner] - nums[i] < mid)
                    left = midInner;
                else
                    right = midInner;
            }
            if (nums[right] - nums[i] < mid)
                ans += right - i;
            else if (nums[left] - nums[i] < mid)
                ans += left - i;
        }
        return ans >= k;
    }
}
