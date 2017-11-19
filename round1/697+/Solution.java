import java.util.*;

class Solution {
    public int findShortestSubArray(int[] nums) {
        List<Integer> candidates = new ArrayList<>();
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            maxCount = Math.max(maxCount, map.get(n));
        }
        
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount)
                candidates.add(key);
        }
        
        int minLength = nums.length;
        for (int candidate : candidates) {
            int i = 0, j = nums.length - 1;
            while (i <= j && nums[i] != candidate)
                i++;
            while (i <= j && nums[j] != candidate)
                j--;
            minLength = Math.min(minLength, j - i + 1);
        }
        return minLength;
    }
}
