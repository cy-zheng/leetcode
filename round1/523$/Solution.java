/*
    前缀和的思路可以做，但是时间O(n^2)，空间O(n)
    
    Discuss 解法很赞：
    遍历数组的同时计算部分和，使用部分和对k去余，如果同一个余数出现了两次，就认为出现了一个子数组，和为k的倍数
    比如：
    数组：  23 2 4 6 7
    部分和：23 25 29 35 42
    取余：  5 1 5 5 0
    
    对于k = 0而言，必须子数组和为0才符合要求。部分和出现两次就意味着出现了这样的子数组
*/
import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k; 
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true; // 子数组长度必须大于2
            }
            else map.put(runningSum, i);
        }
        return false;
    }
}
