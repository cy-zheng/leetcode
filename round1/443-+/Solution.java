class Solution {
    public int compress(char[] chars) {
        int i = 0, j = 0, k = 0;
        while (k < chars.length) {
            while (k < chars.length && chars[j] == chars[k])
                k++;
            int length = k - j;
            chars[i] = chars[j];
            i++;
            if (length != 1) {
                int shift = 1;
                while (length / shift != 0)
                    shift *= 10;
                shift /= 10;
                while (shift != 0) {
                    chars[i] = (char) ('0' + length / shift);
                    i++;
                    length %= shift;
                    shift /= 10;
                }
            }
            j = k;
        }
        return i;
    }
}
