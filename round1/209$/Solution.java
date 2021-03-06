/*
    两个指针, start end, end向后走,直到 sum 大于 s. 然后start向后, 直到sum 小于s. 同时更新 min值.
*/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;  
        int end = 0;  
          
        int sum = 0;  
        int min = Integer.MAX_VALUE;  
          
        while(start<nums.length && end<nums.length) {  
            while(sum<s && end<nums.length) {  
                sum += nums[end++];  
            }  
            while(sum>=s && start<=end) {  
                min = Math.min(min, end-start);  
                sum -= nums[start++];  
            }  
        }  
        return min==Integer.MAX_VALUE ? 0 : min;  
    }
}