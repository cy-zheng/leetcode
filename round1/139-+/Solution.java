/*
    HashSet比较元素使用obj.equals
    DFS超时，需要用单序列dp
*/

import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        if (wordDict == null || wordDict.size() == 0) return false;
        
        Set<String> dict = new HashSet<>();
        for(String s1 : wordDict) {
            dict.add(s1);
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i < s.length() + 1; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (dp[j] && dict.contains(s.substring(j, i)))
                    dp[i] = true;
                j--;
            }
        }
        
        return dp[s.length()];
    }
}