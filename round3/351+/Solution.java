import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    
    public int numberOfPatterns(int m, int n) {
        map.put("1,3", 2);
        map.put("1,7", 4);
        map.put("1,9", 5);
        map.put("3,7", 5);
        map.put("3,9", 6);
        map.put("7,9", 8);
        map.put("4,6", 5);
        map.put("2,8", 5);
        int result = 0;
        for (int i = m; i <= n; i++) {
            result += dfs(new HashSet<>(), 0, i);
        }
        return result;
    }
    
    private int dfs(Set<Integer> visited, int pre, int remain) {
        if (remain == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= 9; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                if (pre == 0) {
                    result += dfs(visited, i, remain - 1);
                }
                else {
                    int min = Math.min(i, pre);
                    int max = Math.max(i, pre);
                    if (!map.containsKey(min + "," + max) || visited.contains(map.get(min + "," + max))) {
                        result += dfs(visited, i, remain - 1);
                    }
                }
                visited.remove(i);
            }   
        }
        return result;
    }
}
