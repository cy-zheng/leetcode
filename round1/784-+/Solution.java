import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null)
            return new LinkedList<>();
        List<String> result = new LinkedList<>();
        dfs(result, new StringBuilder(S), 0);
        return result;
    }
    
    private void dfs(List<String> result, StringBuilder sb, int index) {
        if (index >= sb.length()) {
            result.add(sb.toString());
            return;
        }
        char curr = sb.charAt(index);
        if (curr >= '0' && curr <= '9') {
            dfs(result, sb, index + 1);
        }
        else {
            sb.setCharAt(index, Character.toLowerCase(curr));
            dfs(result, sb, index + 1);
            sb.setCharAt(index, Character.toUpperCase(curr));
            dfs(result, sb, index + 1);
        }
    }
}
