/*
    双指针，注意对重复元素的判断
*/

import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        int result = 0;
        if (nums == null || nums.length == 0 || k < 0)
            return result;
        
        Arrays.sort(nums);
        int i = 0, j = 1;
        
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && j < nums.length && nums[j] - nums[i] < k)
                j++;
            if (i < nums.length && j < nums.length && nums[j] - nums[i] == k)
                result++;
            i++;
            while (i < nums.length && j < nums.length && i != 0 && nums[i] == nums[i - 1])
                i++;
            while (i < nums.length && j < nums.length && j != 0 && nums[j] == nums[j - 1])
                j++;
            if (j <= i)
                j = i + 1;
        }
        return result;
    }
}