/*
    这道题follow up很难，主要思路是先用quick select找到中间的一个元素，然后拆成两半，重新排序。
    但是如果中间元素是重复的，那么问题就比较复杂。
    这次没做出来。
*/

import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] helper = Arrays.copyOf(nums, nums.length);
        int mid = (nums.length + 1) / 2;
        int i = mid - 1, j = nums.length - 1;
        int cnt = 0;
        while (i >= 0 && j >= mid) {
            nums[cnt] = helper[i];
            cnt++;
            i--;
            nums[cnt] = helper[j];
            cnt++;
            j--;
        }
        if (cnt < nums.length)
            nums[cnt] = helper[i];
    }
}