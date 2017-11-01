class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        boolean reverse = true;
        int i = 0;
        while (i < s.length()) {
            StringBuilder tmp = new StringBuilder();
            int index = i;
            while (i < Math.min(s.length(), index + k)) {
                tmp.append(s.charAt(i));
                i++;
            }
            if (reverse)
                tmp = tmp.reverse();
            result.append(tmp.toString());
            reverse = !reverse;
        }
        return result.toString();
    }
}