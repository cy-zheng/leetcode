class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int result = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[i] == 0 && nums[j] == 0) {
                i++;
                j++;
            }
            else if(nums[i] == 1 && nums[j] == 0) {
                result = Math.max(j - i, result);
                i = j;
            }
            else 
                j++;
        }
        if (i < nums.length && nums[i] == 1) {
            result = Math.max(result, nums.length - i);
        }
        return result;
    }
}