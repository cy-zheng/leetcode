/*
    先排序，按照从小到大分
*/

import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                result++;
            }
            else
                j++;
        }
        return result;
    }
}