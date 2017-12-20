/*
    leetcode 16
    和3Sum的思路是一样的，加上中间路径比较一下和target的diff，最后保留一个最小的diff
*/

import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            int newTarget = target - nums[i];
            while (left < right) {
                if (Math.abs(newTarget - nums[left] - nums[right]) < minDiff) {
                    minDiff = Math.abs(newTarget - nums[left] - nums[right]);
                    result = nums[i] + nums[left] + nums[right];
                }
                if (nums[left] + nums[right] < newTarget)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}
