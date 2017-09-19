/*
    类似于背包问题，但是结果可以允许元素相同，顺序不同的解出现。
    所以这道题不能用背包的思路。
    需要遍历之前的，加和，相当于把需要的元素插入到原有数组的尾部，不需要考虑插入这个元素之后，原有的数组会不会出现新的排列。
*/
import java.util.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
                else
                    break;
            }
        }
        return dp[target];
    }
}