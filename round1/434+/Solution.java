class Solution {
    public int countSegments(String s) {
        int result = 0;
        boolean inWord = false;
        for (int i = 0; i < s.length(); i++) {
            if (!inWord && s.charAt(i) != ' ') {
                result++;
                inWord = true;
            }
            else if (inWord && s.charAt(i) == ' ') {
                inWord = false;
            }
        }
        return result;
    }
}