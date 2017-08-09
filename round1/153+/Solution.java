public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = (right - left) / 2 + left;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            else {
                if (nums[mid] > nums[left]) {
                    left = mid;
                }
                else {
                    right = mid;
                }
            }
        }
        
        if (nums[left] < nums[right])
            return nums[left];
        else
            return nums[right];
            
    }
}