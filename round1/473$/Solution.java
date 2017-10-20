/*
    Discuss的剪枝做的很漂亮，剪枝的代码参考注释。
*/

class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false; // 和不能被4整除
        
        /*
            让原数组降序排列这个想法很好，从长的开始可以尽早发现失败，从而剪掉这一个分支
            Reason behind this is we always try to put the next matchstick in the first subset. If there is no solution, trying a longer matchstick first will get to negative conclusion earlier. 
        */
        Arrays.sort(nums);  
        reverse(nums);
        
        return dfs(nums, new int[4], 0, sum / 4);
    }
    
    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
            return true;
            }
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;          // 剪枝，当前元素使得sum[i] > target，就没必要继续了
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }
        
        return false;
    }
    
    private void reverse(int[] nums) {        // 两根指针反序
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}