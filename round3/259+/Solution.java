class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    result += k - j;
                }
                if (nums[j] + nums[k] < target - nums[i]) {
                    j += 1;
                } 
                else {
                    k -= 1;
                }
            }
        }
        return result;
    }
}
