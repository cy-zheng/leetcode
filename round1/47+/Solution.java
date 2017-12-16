import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, visited);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] visited) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && (i == 0 || nums[i - 1] != nums[i] || visited[i - 1])) {
                visited[i] = true;
                curr.add(nums[i]);
                dfs(result, curr, nums, visited);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }
}
