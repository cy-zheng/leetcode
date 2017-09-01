/*
    单序列dp可以做到N^2，NlogN还需要使用耐心排序法
    参考：https://segmentfault.com/a/1190000003819886
    保持一组(1)不同长度(2)且保证该升序序列在同长度升序序列中末尾最小 的升序序列
    遍历每个元素，二分查找当前序列们的尾端，更新序列
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int result = 1;
        for (int i = 0; i < nums.length; i++) 
            dp[i] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}