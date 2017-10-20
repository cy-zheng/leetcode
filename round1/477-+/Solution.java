/*
    记录各个bit位出现1的个数，Hamming距离 += 1的个数 * 0的个数
*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length <= 1) 
            return 0;
        int result = 0;
        int[] countBits = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0)
                    countBits[i]++;
            }
        }
        for (int c : countBits) {
            result += c * (nums.length - c);
        }
        return result;
    }
}