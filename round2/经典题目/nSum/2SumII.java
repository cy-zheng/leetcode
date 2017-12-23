/*
    leetcode 167
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (target == nums[left] + nums[right]) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            else if (target < nums[left] + nums[right])
                right--;
            else
                left++;
        }     
        return result;
    }
}
