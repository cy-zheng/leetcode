import java.util.*;

class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), n);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int remain) {
        if (path.size() > 0) {
            List<Integer> tmp = new ArrayList<>(path);
            tmp.add(remain);
            result.add(tmp);
        } 
        for (int i = 2; i <= (int) (Math.sqrt(remain) + 0.0001); i++) {
            if (path.size() != 0 && path.get(path.size() - 1) > i)
                continue;
            int j = remain / i;
            if (i * j == remain) {
                path.add(i);
                dfs(result, path, j);
                path.remove(path.size() - 1);
            }
        }
    }
}
