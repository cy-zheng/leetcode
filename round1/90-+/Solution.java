import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int start) {
        result.add(new ArrayList<>(path));
        if (start >= nums.length)
            return;
        
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) // 注意这种去重方式要基于数据本身是有序的
                continue;
            path.add(nums[i]);
            dfs(result, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
