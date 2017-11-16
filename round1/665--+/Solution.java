/*
    When you find nums[i-1] > nums[i] for some i, you will prefer to change nums[i-1]'s value, since a larger nums[i] will give you more risks that you get inversion errors after position i. But, if you also find nums[i-2] > nums[i], then you have to change nums[i]'s value instead, or else you need to change both of nums[i-2]'s and nums[i-1]'s values.
*/

import java.util.*;

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean result = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i + 2 >= nums.length || nums[i + 2] >= nums[i])
                    nums[i + 1] = nums[i];
                else
                    nums[i] = nums[i + 1];
                result = false;
                break;
            }
        }
        
        if (result)
            return result;
        
        result = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i + 2 >= nums.length || nums[i + 2] >= nums[i])
                    nums[i + 1] = nums[i];
                else
                    nums[i] = nums[i + 1];
                result = false;
                break;
            }
        }
        return result;
    }
}
