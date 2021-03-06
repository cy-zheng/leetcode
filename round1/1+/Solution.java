public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = (right - left) / 2 + left;
            if (nums[left] < nums[right]){
                return nums[left];
            }
            else {
                if (nums[left] < nums[mid])
                    left = mid;
                else if(nums[left] > nums[mid])
                    right = mid;
                else{
                    if (smallerInLeft(nums, mid))
                        right = mid;
                    else
                        left = mid;
                }
            }
        }
        if (nums[left] < nums[right])
            return nums[left];
        return nums[right];
    }

    private boolean smallerInLeft(int[] nums, int index) {
        int left = index - 1;
        while (left >= 0) {
            if (nums[left] < nums[index])
                return true;
            left--;
        }
        return false;
    }
}