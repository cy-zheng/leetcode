/*
    找一个单向的圈，圈中元素都大于零或者都小于零
    圈最小长度为2
    这题不是很好
*/

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (hasLoop(nums, i, nums[i] > 0))
                return true;
        }
        return false;
    }
    
    private boolean hasLoop(int[] nums, int index, boolean isForward) {
        int curr = index;
        int size = 0;
        while (testIndex(nums, curr, isForward) && size <= nums.length) {
            size += 1;
            int next = (curr + nums[curr] + nums.length) % nums.length;
            if (curr == next)
                break;
            curr = next;
        }
        return size > nums.length;
    }
    
    private boolean testIndex(int[] nums, int index, boolean isForward) {
        if (nums[index] == 0) return false;
        if (isForward && nums[index] < 0)
            return false;
        if (!isForward && nums[index] > 0)
            return false;
        return true;
    }
}