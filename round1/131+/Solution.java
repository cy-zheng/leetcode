import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        
        dfs(s, 0, new ArrayList<String>(), result);
        return result;
    }
    
    private void dfs(String s, int start, List<String> path, List<List<String>> result) {
        if (start >= s.length()) {
            List<String> tmp = new ArrayList<>();
            tmp.addAll(path);
            result.add(tmp);
            return;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end));
                dfs(s, end, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        end--;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}