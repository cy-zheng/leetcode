public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        int tmp;
        for (int i = 0; i < 32; i++) {
            tmp = (1 << i) & n;
            if (tmp != 0)
                result++;
        }
        return result;
    }
}