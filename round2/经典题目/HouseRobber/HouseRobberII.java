/*
    leetcode 213
    HouseRobber，房子围成一个圈
    dp1代表最后一个房子不能选
    dp2代表最后一个房子可以选，那么第一个房子不能选
*/

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[0] = 0;
        dp2[1] = nums[1];
        
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
            dp2[i] = Math.max(nums[i] + dp2[i - 2], dp2[i - 1]);
        }
        
        return Math.max(nums[nums.length - 1] + (nums.length - 3 < 0 ? 0 : dp2[nums.length - 3]) , dp1[nums.length - 2]);
        
    }
}
