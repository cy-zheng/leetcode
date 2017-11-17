class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int r = 1, c = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                c++;
            }
            else
                c = 1;
            r = Math.max(r, c);
        }
        return r;
    }
}