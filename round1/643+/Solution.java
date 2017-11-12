class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= k - 1) {
                sum += nums[i];
                if (i == k - 1)
                    max = Math.max(max, sum / k);
            }
            else {
                sum -= nums[i - k];
                sum += nums[i];
                max = Math.max(max, sum / k);
            }
        }
        return max;
    }
}
