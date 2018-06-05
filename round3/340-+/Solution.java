class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0)
            return 0;
        int[] count = new int[256];
        int left = 0, curr = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 0)
                curr += 1;
            count[s.charAt(i)] += 1;
            while (curr > k && left < i) {
                count[s.charAt(left)] -= 1;
                if (count[s.charAt(left)] == 0)
                    curr -= 1;
                left += 1;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
