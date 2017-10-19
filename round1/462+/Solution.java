/*
    把所有数字变成中位数
*/

class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int mid;
        int result = 0;
        if (nums.length % 2 == 1)
            mid = findKthSmallest(nums, (nums.length - 1) / 2, 0, nums.length - 1);
        else
            mid = findKthSmallest(nums, nums.length / 2 - 1, 0, nums.length - 1);
        for (int n : nums) {
            result += Math.abs(n - mid);
        }
        return result;
    }
    
    // k是相对于start的偏移量，k从0开始
    public int findKthSmallest(int[] nums, int k, int start, int end) {
        if (start == end)
            return nums[start];
        
        int i = start, j = end;
        int pivot = nums[(start + end) / 2];
        int tmp;
        while (i <= j) {
            while (i <= j && nums[i] < pivot) 
                i++;
            while (i <= j && nums[j] > pivot)
                j--;
            if (i <= j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        
        if (start + k <= j)            // 第k个元素在j的左手边，包含j
            return findKthSmallest(nums, k, start, j);
        if (start + k >= i)           // 第k个元素在i的右手边，包含i
            return findKthSmallest(nums, k - (i - start), i, end);
        return nums[j + 1];          // 在j和i之间
    }
}