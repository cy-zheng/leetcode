/*
    将每个元素对应位置+n，最后统计各个位置有没有超过2n
*/

import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            while (curr > n)
                curr -= n;
            nums[curr - 1] += n;
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n)
                result.add(i + 1);
        }
        
        return result;
    }
}