class Solution {
    public int monotoneIncreasingDigits(int N) {
        StringBuilder sb = new StringBuilder(Integer.toString(N));
        sb.insert(0, '0');

        int lastIndex = -1;

        for (int i = sb.length() - 2; i >= 0; i--) {
            if (sb.charAt(i) > sb.charAt(i + 1)) {
                sb.setCharAt(i, (char) (sb.charAt(i) - 1));
                lastIndex = i;
            }
        }

        if (lastIndex != -1) {
            for (int i = lastIndex + 1; i < sb.length(); i++) {
                sb.setCharAt(i, '9');
            }
        }

        return Integer.parseInt(sb.substring(1));
    }
}
