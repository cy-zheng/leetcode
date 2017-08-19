import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        
        int left = nums[0], right = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == right + 1)
                right = nums[i];
            else {
                if (left == right)
                    result.add(Integer.toString(left));
                else 
                    result.add(left + "->" + right);
                
                left = nums[i];
                right = nums[i];
            }
        }
        
        if (left == right)
            result.add(Integer.toString(left));
        else 
            result.add(left + "->" + right);
        
        return result;
    }
}