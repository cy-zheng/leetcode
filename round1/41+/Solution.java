/*
    把数字 + n，存在原来的格子里面
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 1 || nums[i] > n)
                nums[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr > n)
                curr -= n + 1;
            if (curr != 0 && nums[curr - 1] <= n)
                nums[curr - 1] += n + 1;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n)
                return i + 1;
        }
        return n + 1;
    }
}
