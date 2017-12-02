/*
    答案来源于Discuss
    思路：
    首先对于两个数组，每个生成一个最大数字，
    然后合并两个数字，使生成的结果是最大数字
*/

class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }
    
    // 合并两个数组，选择较大数字的第一个元素放入结果
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }
    
    // 判断两个子数组谁比较大，great的定义很有意思，是谁靠前的数字比较大
    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    
    // 从单个数组中获取k位的一个最大数字
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            // 第一个条件：剩下的元素够k个，第三个条件，之前的元素小于nums[j]
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            // nums[i] 赋值给ans[j]，j后移
            if (j < k) ans[j++] = nums[i];
        }     // 其实归纳为一句话，只要剩下的数字还够，当前的ans比nums要小，就选择nums作为ans。注意while
        return ans;
    }
}
