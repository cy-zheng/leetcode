class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) 
                right = mid;
            else
                left = mid;
        }
        
        if (nums[left] >= target)
            return left;
        if (nums[right] >= target)
            return right;
        return right + 1;
    }
}