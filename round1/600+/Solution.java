/*
     比较难的一道题目
     首先把这个数字转换为小于当前数字的，1不相邻的最大数字，然后使用dp求解最大数字的结果
     
     构造最大数字：
     一旦出现两个连续的1，第二个1改成0，之后按照1010交错排列
*/

class Solution {
    public int findIntegers(int num) {
        int bitCount = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                bitCount = i + 1;
            }
        }
        int[] dp = new int[32]; // dp的含义是对应位是1，增加的结果数
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 0;
        num = getMaxValid(num);  // 求解会受num中连续1的影响，先求小于num的最大的不连续1的数字
        for (int i = bitCount - 1; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                    result += dp[i];
            }
        }
        result++;
        return result;
    }

    private int getMaxValid(int num) {
        boolean preIsOne = false;
        for (int i = 31; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                if (preIsOne) {
                    for (int j = i; j >= 0; j--) {
                        if ((num & (1 << (j + 1))) != 0)
                            num &= ~(1 << j);
                        else
                            num |= (1 << j);
                    }
                    break;
                }
                else
                    preIsOne = true;
            }
            else
                preIsOne = false;
        }
        return num;
    }
}
