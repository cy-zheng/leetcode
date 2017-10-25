/*
    单调栈的思路
*/

import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] helper = new int[nums2.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            map.put(nums2[i], i);
            while (stack.size() > 0 && stack.peek() <= nums2[i])
                stack.pop();
            helper[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = helper[map.get(nums1[i])];
        }
        return result;
    }
}