import java.util.*;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0 || sum < k) return false;
        sum = sum / k;
        return possible(nums, sum, new int[k], nums.length - 1);
    }
    
    boolean possible(int[] nums, int sum, int[] p, int idx) {
        if (idx == -1) {
            for (int s : p) if (s != sum) return false;
            return true;
        }
        
        int num = nums[idx];
        
        for (int i = 0; i < p.length; i++) {
            if (p[i] + num <= sum) {
                p[i] += num;
                if (possible(nums, sum, p, idx - 1)) return true;
                p[i] -= num;
            }
        }
        return false;
    }    
}
