/*
    这道题的核心思想，在于通过二分搜索，遍历average，从而求解sum - average数组，在窗口大于k时，是否存在一个连续数组的和大于0
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : nums) {
            max = Math.max(max, i);
            sum += i;
        }
        
        double left = sum * 1.0 / nums.length, right = max;
        while (left + 0.000001 < right) {
            double mid = (left + right) / 2;
            if (check(nums, k, mid))
                left = mid;
            else
                right = mid;
        }
        return left;
    }
    
    private boolean check(int[] nums, int k, double average) {
        double[] sum = new double[nums.length + 1];
        double[] minPrefix = new double[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i] - average;
            minPrefix[i + 1] = Math.min(minPrefix[i], sum[i + 1]);
            if (i >= k - 1 && sum[i + 1] - minPrefix[i + 1 - k] >= 0) {
                return true;
            }
        }
        return false;
    }
}
