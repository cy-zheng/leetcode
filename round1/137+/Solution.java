/*
    建立一个长度为32的int数组，记录各个位的情况。
    如果某一位出现了3次，则reset为0。
    这是一种实现模三异或的思路。
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