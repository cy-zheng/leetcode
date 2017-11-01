/*
    二分法
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (isEven(nums, mid))
                left = mid;
            else
                right = mid;
        }
        if (isSingle(nums, left))
            return nums[left];
        return nums[right];
    }
    
    private boolean isSingle(int[] nums, int i) {
        if (i - 1 >= 0 && nums[i - 1] == nums[i])
            return false;
        if (i + 1 < nums.length && nums[i + 1] == nums[i])
            return false;
        return true;
    }
    
    private boolean isEven(int[] nums, int i) {
        if (i % 2 == 0) {
            if (i + 1 >= nums.length)
                return false;
            return nums[i + 1] == nums[i];
        }
        else {
            return nums[i - 1] == nums[i];
        }
    }
}