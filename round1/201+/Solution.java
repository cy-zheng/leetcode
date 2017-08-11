public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int diff = n - m + 1;
        int result = 0, range;
        for (int i = 0; i < 32; i++) {
            range = 1 << i;
            if (i == 31 || diff <= range) {
                if (((m & (1 << i)) & (n & (1 << i))) > 0) {
                    result |= (1 << i);
                }
            }
        }
        return result;
    }
}