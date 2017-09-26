/*
    被tag的dp误导了，其实这道题是一道经典的二分答案
*/

class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        // 二分的left是数组的最大值，right是数组的sum
        return (int) binarySearch(nums, max, sum, m);
    }
    
    private long binarySearch(int[] nums, long left, long right, int m) {
        // 对于当前mid，是否存在<=m的切分方式，类似于copy book
        while (left + 1 < right) {
            long mid = (right - left) / 2 + left;
            if (existM(nums, mid, m))
                right = mid;
            else
                left = mid;
        }
        // 选择ooxx最后一个o
        if (existM(nums, left, m))
            return left;
        return right;
    }
    
    private boolean existM(int[] nums, long maxValue, int m) {
        // 判断每个subarray的和小于等于maxValue的前提下，是否子数组个数小于m
        int cnt = 1;
        long currSum = 0;
        for (int num : nums) {
            if (currSum + num > maxValue) {
                currSum = num;
                cnt++;
            }
            else
                currSum += num;
        }
        return cnt <= m;
    }
}