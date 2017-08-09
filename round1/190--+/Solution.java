public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (i <= 15)
                result |= ((1 << 31 - i) & n) >>> (31 - i * 2);
            else
                result |= ((1 << 31 - i) & n) << ((i - 15) * 2 - 1);
        }
        return result;
    }
}