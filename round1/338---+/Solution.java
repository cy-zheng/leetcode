class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int shift = 2;
        int i = 0;
        while (i <= num) {
            if (i == 0) {
                result[i] = 0;
                i++;
            }
            else if (i == 1) {
                result[i] = 1;
                i++;
            }
            else if (i == shift) {
                shift <<= 1;
                while (i < shift && i <= num) {
                    result[i] = result[i - (shift >> 1)] + 1;
                    i++;
                }
            }
        }
        return result;
    }
}