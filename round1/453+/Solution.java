/*
    对n - 1个元素+1，等效于对一个-1
*/

class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i : nums)
            min = Math.min(i, min);
        for (int i : nums)
            result += i - min;
        return result;
    }
}