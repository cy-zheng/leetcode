class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int step = 1;
        int maxDist = nums[0];
        int curr = 0;
        while (true) {
            if (maxDist >= nums.length - 1)
                return step;
            int tmp = maxDist;
            for (int i = curr; i < Math.min(maxDist + 1, nums.length); i++) {
                tmp = Math.max(tmp, i + nums[i]);
            }
            step++;
            curr = maxDist;
            maxDist = tmp;
        }
    }
}
