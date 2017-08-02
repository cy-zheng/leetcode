/*
    "    010" -> 10：去头部空格
    result > (1L << 31) - 1这样写才是正确的，result > 1L << 31 - 1不对，result > (1L << 31 - 1)不对
    越界根据正负号返回Integer.MAX_VALUE，Integer.MIN_VALUE
    还要注意long变量越界情况
*/

public class Solution {
    public int myAtoi(String str) {
        long result = 0;
        boolean isPositive = true;
        boolean hasSign = false;

        for (int i = 0; i < str.length(); i++) {
            if (!hasSign && str.charAt(i) == ' ') {
                continue;
            }
            if (!hasSign && str.charAt(i) == '+') {
                hasSign = true;
                continue;
            }
            if (!hasSign && str.charAt(i) == '-') {
                isPositive = false;
                hasSign = true;
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            result *= 10;
            if (result < 0) break;
            result += str.charAt(i) - '0';
            if (result < 0) break;
            hasSign = true;
        }
        if (result < 0 || (isPositive && result > (1L << 31) - 1) || (!isPositive && result > (1L << 31))) {
            if (isPositive)
                return (1 << 31) - 1;
            else
                return 1 << 31;
        }
        if (isPositive)
            return (int)result;
        else
            return (int)(-result);
    }
}