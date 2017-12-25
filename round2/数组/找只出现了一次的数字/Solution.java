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

/*
    leetcode 260
    有两个数出现了一次，其他的数字都出现了两次。按着两个数字的最低位，把所有数字分成两组
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int diff = 0;
        // diff 是那两个单独的数异或的结果
        for (int num : nums) 
            diff ^= num;
        // 变换 diff ，使得 diff 从低位到高位的第一个1留下，其它位置上都置0
        diff &= -diff;
        // 这样，根据最低一位的不同，这一组数就变成了两组数，分别包含一个单独的数
        // 对每组数异或，得到的就是答案
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            }
            else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
