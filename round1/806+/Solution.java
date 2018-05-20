class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int result = 0, length = 0;
        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            if (length + widths[curr - 'a'] > 100) {
                result += 1;
                length = widths[curr - 'a'];
            }
            else {
                length += widths[curr - 'a'];
            }
        }
        if (length > 0)
            result += 1;
        return new int[] {result, length};
    }
}
