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