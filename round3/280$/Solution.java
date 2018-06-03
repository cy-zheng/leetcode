class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i - 1] < nums[i])
                    swap(nums, i - 1, i);
            }
            else {
                if (nums[i - 1] > nums[i])
                    swap(nums, i - 1, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
