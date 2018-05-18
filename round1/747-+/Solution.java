class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1)
            return 0;
        
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                index = i;
                second = first;
                first = nums[i];
            }
            else if (nums[i] > second) {
                second = nums[i];
            } 
        }
        return second * 2 <= first ? index : -1;
    }
}
