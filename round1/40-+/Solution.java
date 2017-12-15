import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(result, new ArrayList<>(), candidates, 0, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> curr, int[] candidates, int start, int currSum, int target) {
        if (start >= candidates.length || currSum >= target) {
            if (currSum == target)
                result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            curr.add(candidates[i]);
            dfs(result, curr, candidates, i + 1, currSum + candidates[i], target);
            curr.remove(curr.size() - 1);
        }
    }
}
