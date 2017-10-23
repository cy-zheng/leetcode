/*
    要注意：
    1、数组不能重排序
    2、去重时，不能只看当前元素上一个，因为数组此时是无序的
*/

import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        dfs(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> path, int start) {
        if (path.size() >= 2) {
            List<Integer> tmp = new ArrayList<>(path);
            result.add(tmp);
        }
        Set<Integer> set = new HashSet<>();            // 相同一层使用set去重，存在多个元素时，确保只访问第一个
        for (int i = start; i < nums.length; i++) {
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                if (set.contains(nums[i]))
                    continue;
                set.add(nums[i]);
                path.add(nums[i]);
                dfs(result, nums, path, i + 1);
                path.remove(path.size() - 1);
            }    
        }
    }
}