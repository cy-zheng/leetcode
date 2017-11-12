class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] r = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while (n >= 20000)
                n -= 20000 + i + 1;
            nums[i] -= n;
            nums[n - 1] += 20000 + n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 40000)
                r[0] = i + 1;
            if (nums[i] < 20000)
                r[1] = i + 1;
        }
        return r;
    }
}
