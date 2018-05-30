/*
    比较tricky的一道题目，先把整个反过来，然后翻转每个单词，类似三步翻转法。
    如果只有一个单词，就不需要处理了。
*/

class Solution {
    public void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
