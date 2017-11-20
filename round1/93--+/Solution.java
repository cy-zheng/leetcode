import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), s, 0);
        return result;
    }
    
    private void dfs(List<String> result, List<Integer> path, String s, int start) {
        if (start >= s.length()) {
            if (path.size() == 4) {
                StringBuilder sb = new StringBuilder();
                for (int p : path) {
                    if (sb.length() != 0)
                        sb.append(".");
                    sb.append(Integer.toString(p));
                }
                result.add(sb.toString());
            }
            return;
        }
        
        int curr = s.charAt(start) - '0';
        if (path.size() == 0) {
            path.add(curr);
            dfs(result, path, s, start + 1);
            path.remove(path.size() - 1);
        }
        else {
            if (path.get(path.size() - 1) != 0 && path.get(path.size() - 1) * 10 + curr <= 255) {
                int tmp = path.get(path.size() - 1);
                path.set(path.size() - 1, tmp * 10 + curr);
                dfs(result, path, s, start + 1);
                path.set(path.size() - 1, tmp);
            }
            path.add(curr);
            dfs(result, path, s, start + 1);
            path.remove(path.size() - 1);
        }
    }
}
