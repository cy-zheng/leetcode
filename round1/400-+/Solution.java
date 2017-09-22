/*
    依次判断，n > 9 则 - 9 * 1
    n > 90 则 - 90 * 2
    找到包含着一位的数字，截取其中一个数
*/

class Solution {
    public int findNthDigit(int n) {
        int shift = 10;
        long tmp = 9L * shift / 10 * (Integer.toString(shift).length() - 1);
        while (tmp < n) {
            n -= tmp;
            shift *= 10;
            tmp = 9L * shift / 10 * (Integer.toString(shift).length() - 1);
        }
        shift /= 10;

        int length = Integer.toString(shift).length();
        int num = shift + (n - 1) / length;
        return Integer.toString(num).charAt((n - 1) % length) - '0';
    }
}