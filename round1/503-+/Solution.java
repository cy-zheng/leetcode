/*
    循环数组，把原数组倍增
*/

import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] nn = new int[2 * nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            nn[i] = nums[i];
            if (i != nums.length - 1)
                nn[i + nums.length] = nums[i];
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = nn.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() <= nn[i])
                stack.pop();
            if (i < nums.length) {
                result[i] = stack.size() > 0 ? stack.peek() : -1;
            }
            stack.push(nn[i]);
        }
        return result;
    }
}