/*
    target出现了一次，其他出现了两次。
    基为2的异或运算
*/

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int result = nums[0];
        for (int i = 1; i < nums.length; i++)
            result ^= nums[i];
        
        return result;
    }
}

/*
    target出现了一次，其他出现了三次。
    基3的异或运算
*/

public class Solution {
    public int singleNumber(int[] nums) {
        int[] digits = new int[32];
        int result = 0;
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                digits[i] += (n >> i) % 2;
                digits[i] %= 3;
            }
        }
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            if (digits[i] != 0) {
                result += 1;
            }
        }
        
        return result;
    }
}
