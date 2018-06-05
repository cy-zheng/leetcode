import java.util.*;

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        dfs(result, 0, 0, "", word);
        return result;
    }
    
    private void dfs(List<String> result, int cnt, int pos, String curr, String word) {
        if (pos == word.length()) {
            // 最后一位，如果cnt不为零补上
            if (cnt != 0)
                curr += cnt;
            result.add(curr);
            return;
        }
        // 当前位省略掉
        dfs(result, cnt + 1, pos + 1, curr, word);
        // 不省略当前位，需要补cnt
        dfs(result, 0, pos + 1, (cnt == 0 ? curr : curr + cnt) + word.charAt(pos), word);
    }
}
