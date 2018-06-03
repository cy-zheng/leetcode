import java.util.*;

class Solution {
    
    Map<String, Boolean> map;
    
    public boolean canWin(String s) {
        map = new HashMap<>();
        char[] list = s.toCharArray();
        return dfs(list);
    }
    
    private boolean dfs(char[] list) {
        String s = new String(list);
        if (map.containsKey(s))
            return map.get(s);
        boolean result = true;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == '+' && list[i + 1] == '+') {
                list[i] = '-';
                list[i + 1] = '-';
                result &= dfs(list);
                list[i] = '+';
                list[i + 1] = '+';
            }
        }
        map.put(s, !result);
        return !result;
    }
}
