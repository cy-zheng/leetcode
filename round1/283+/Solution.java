/*
    不能改变非0元素之间的相对顺序
    同向双指针
    一个指向第一个不是0的，一个指向第一个0
*/

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int left = 0; 
        int right = 0;
        while (left < nums.length && right < nums.length) {
            while (left < nums.length && nums[left] != 0)
                left++;
            while (right < nums.length && nums[right] == 0)
                right++;
            if (left < nums.length && right < nums.length && left < right) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
            }
            else {
                right++;
            }
        }
    }
}