/*
    leetcode 368
    先把数组排序，每个数朝前找能被整除的数就行。这个想法是因为1， 2， 3这样的subset永远不会出现
    需要使用一个parents数组保存dp路径
*/

import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<Integer>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] parents = new int[nums.length];
        int maxSize = 1, maxIndex = 0;
        dp[0] = 1;
        parents[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            parents[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parents[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = parents[maxIndex];
        }
        return result;
    }
}
