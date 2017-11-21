/*
    参考：
    http://bookshadow.com/weblog/2016/10/16/leetcode-longest-repeating-character-replacement/
    滑动窗口（Sliding Window）
    定义一段区间内出现次数最多的字符为“优势字符”
    维护有效区间[p1, p2]，使得区间内除“优势字符”外的其余字符个数不大于k
    时间复杂度O(m * n)，其中m为字母个数, n为字符串长度
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int result = 0;
        int p1 = 0, p2 = 0;
        while (p2 < s.length()) {
            count[s.charAt(p2) - 'A']++;
            while (p2 - p1 + 1 - getMax(count) > k) {
                count[s.charAt(p1) - 'A']--;
                p1++;
            }
            result = Math.max(result, p2 - p1 + 1);
            p2++;
        }
        return result;
    }
    
    private int getMax(int[] count) {
        int result = 0;
        for (int c : count)
            result = Math.max(result, c);
        return result;
    }
}
