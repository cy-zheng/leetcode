class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, left = 0, zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                while (zero > 0) {
                    if (nums[left] == 0)
                        zero -= 1;
                    left += 1;
                }
                zero += 1;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
