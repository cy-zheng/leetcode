import java.util.*;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int result = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                result = Math.max(result, i - map.get(sum - k));
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return result;
    }
}
