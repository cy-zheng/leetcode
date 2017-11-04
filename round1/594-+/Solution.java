import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        int result = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            while (nums[j] - nums[i] > 1) {
                i++;
            }
            if (nums[j] - nums[i] == 1)
                result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}
