/*
    能想到最好的答案是N^2的，Discuss O(N)的方法更优
    
    不能直接用双指针，是因为不确定子串中应该有多少个不同的字符，所以不知道前面字符应不应该出去
    这个做法遍历26种字符，每次都假设字串中只有h种字符，这样就好判断前面的字符是否应该出去
*/

public class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;
        
        for (h = 1; h <= 26; h++) {  // 包含1种字符时，noLessThanK最大是多少……包含26种字符时，noLessThanK最大是多少
            Arrays.fill(counts, 0);
            i = 0;  // 双指针
            j = 0;
            unique = 0;          // 不同的字母个数
            noLessThanK = 0;    // >= k的字母个数
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';    // 后边的进来
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                }
                else {
                    idx = str[i] - 'a';       // 前面的出去
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)  // 只包含h种字符，且h种字符出现次数都>=k
                    max = Math.max(j - i, max);
            }
        }
        
        return max;
    }
}