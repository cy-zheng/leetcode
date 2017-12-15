import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n, n * 2);
        return result;
    }
    
    private void dfs(List<String> result, String curr, int leftNum, int rightNum, int finalLength) {
        if (curr.length() == finalLength) {
            result.add(curr);
            return;
        }
        
        if (leftNum != 0) {
            dfs(result, curr + "(", leftNum - 1, rightNum, finalLength);
        }
        if (rightNum != 0 && leftNum < rightNum) {
            dfs(result, curr + ")", leftNum, rightNum - 1, finalLength);
        }
    }
}
