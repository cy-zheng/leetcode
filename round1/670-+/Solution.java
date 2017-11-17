/*
    从左向右搜索，找到右边比该元素大的最大元素，交换。
    如果最大元素有多个，取最靠右的。
*/

class Solution {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        if (nums.length <= 1)
            return num;
        for (int i = 0; i < nums.length; i++) {
            int t1 = nums[i] - '0';
            int target = -1;
            int max = -1;
            for (int j = i + 1; j < nums.length; j++) {
                int t2 = nums[j] - '0';
                if (t2 > t1 && t2 >= max) {
                    max = t2;
                    target = j;
                }
            }
            if (target != -1) {
                char tmp = nums[target];
                nums[target] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(nums));
    }
}
