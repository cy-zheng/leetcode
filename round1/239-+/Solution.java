import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k)
            return new int[0];
        
        int[] result = new int[nums.length - k + 1];
        int left = 0, right = k - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) 
            pq.offer(-nums[i]);
        result[0] = -pq.peek();
        
        for (int i = 1; i < result.length; i++) {
            pq.remove(-nums[left + i - 1]);
            pq.add(-nums[right + i]);
            result[i] = -pq.peek();
        }
        return result;
    }
}