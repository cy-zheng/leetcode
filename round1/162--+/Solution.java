/*
    需要注意一个题目的条件：num[-1] = num[n] = -∞
    意味着如果数组单调，返回最大元素的下标。
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1])
                left = mid;
            else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else
                right = mid;
        }
        if (left > 0 && left < nums.length - 1 && nums[left] > nums[left - 1] && nums[left] > nums[left + 1])
            return left;
        if (right > 0 && right < nums.length - 1 && nums[right] > nums[right - 1] && nums[right] > nums[right + 1])
            return right;
        if (nums[left] > nums[right]) 
            return left;
        return right;
    }
}