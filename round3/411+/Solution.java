/*
    使用二分检查最小长度
    结合了前面几个题的答案：320、408
*/

import java.util.*;

class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        int left = 0, right = target.length();
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (test(target, dictionary, mid) != null)
                right = mid;
            else
                left = mid;
        }
        
        String result = test(target, dictionary, left);
        if (result != null)
            return result;
        result = test(target, dictionary, right);
        if (result != null)
            return result;
        return "";
    }
    
    private String test(String target, String[] dic, int n) {
        for (String abb : generateAbbreviations(target, n)) {
            boolean noConflict = true;
            for (String d : dic) {
                if (validWordAbbreviation(d, abb)) {
                    noConflict = false;
                    break;
                }
            }
            if (noConflict)
                return abb;
        }
        return null;
    }
    
    public List<String> generateAbbreviations(String word, int n) {
        List<String> result = new ArrayList<>();
        dfs(result, 0, 0, "", word, n);
        return result;
    }
    
    private void dfs(List<String> result, int cnt, int pos, String curr, String word, int n) {
        if (curr.length() > n)
            return;
        if (pos == word.length()) {
            // 最后一位，如果cnt不为零补上
            if (cnt != 0)
                curr += cnt;
            if (curr.length() == n)
                result.add(curr);
            return;
        }
        // 当前位省略掉
        dfs(result, cnt + 1, pos + 1, curr, word, n);
        // 不省略当前位，需要补cnt
        dfs(result, 0, pos + 1, (cnt == 0 ? curr : curr + cnt) + word.charAt(pos), word, n);
    }
    
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
}
