/*
    在对应的位置+n
    最后看一下哪些小于n
*/

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currNum = nums[i];
            if (currNum > n)
                currNum -= n + i + 1;
            if (nums[currNum - 1] <= n)
                nums[currNum - 1] += n + currNum;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n)
                result.add(i + 1);
        }
        return result;
    }
}