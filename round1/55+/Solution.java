class Solution {
    public boolean canJump(int[] nums) {
        int maxDist = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > maxDist)
                break;
            maxDist = Math.max(maxDist, i + nums[i]);
        }
        return maxDist >= nums.length - 1;
    }
}
