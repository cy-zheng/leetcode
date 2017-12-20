/*
    leetcode 15
    需要想办法去重
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];
                if (currSum < 0) 
                    left++;
                else if(currSum > 0)
                    right--;
                else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    // 去重
                    while (left < right && nums[left] == tmp.get(1))
                        left++;
                    while (left < right && nums[right] == tmp.get(2))
                        right--;
                }
            }
        }
        
        return result;
    }
}
