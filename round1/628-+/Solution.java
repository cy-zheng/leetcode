/*
    最大的乘积只可能有两种情况
    最小两个 * 最大的 和 最大三个 的乘积
    其实可以不用排序，直接一次遍历找到这五个数字即可
*/

import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }
}