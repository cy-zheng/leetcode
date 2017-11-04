import java.util.*;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int i = 0, j = nums.length - 1;
        
        while (i < nums.length && nums[i] == sorted[i])
            i++;
        while (j >= 0 && nums[j] == sorted[j])
            j--;
        
        return i <= j ? j - i + 1 : 0;
    }
}
