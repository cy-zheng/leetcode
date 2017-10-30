import java.util.*;

class Solution {
    
    private int result = 0;
    
    public int countArrangement(int N) {
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) 
            nums[i] = i + 1;
        
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[N];
        dfs(nums, visited, path);
        return result;
    }
    
    private void dfs(int[] nums, boolean[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            result++;
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i] && ((path.size() + 1) % nums[i] == 0 || nums[i] % (path.size() + 1) == 0)) {  // 注意要一边加一边判断
                    visited[i] = true;
                    path.add(nums[i]);
                    dfs(nums, visited, path);
                    path.remove(path.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}