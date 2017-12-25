/*
    leetcode 215
    选择无序数组中第k大的数字
    quick select算法，O(n)时间复杂度
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quick_select(nums, k, 0, nums.length - 1);
    }
    
    private int quick_select(int[] nums, int k, int start, int end) {
        if (start == end)
            return nums[start];
        
        int i = start, j = end;
        int pivot = nums[(start + end) / 2];
        int tmp;
        while (i <= j) {
            while (i <= j && nums[i] > pivot) 
                i++;
            while (i <= j && nums[j] < pivot)
                j--;
            if (i <= j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
        
        if (start + k - 1 <= j)
            return quick_select(nums, k, start, j);
        if (start + k - 1 >= i)
            return quick_select(nums, k - (i - start), i, end);
        return nums[j + 1];
    }
}
