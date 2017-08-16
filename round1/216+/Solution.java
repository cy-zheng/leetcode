/*
    java中拷贝list的方法：
       List<Integer> copy = new ArrayList<>();
       copy.addAll(curr);
*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> curr = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            curr.add(elements[i]);
            dfs(result, elements, curr, i + 1, k - 1, n);
            curr.remove(curr.size() - 1);
        }
        return result;
    }
    
    private void dfs( List<List<Integer>> result, int[] elements, List<Integer> curr, int start, int step, int target) {
        if (step == 0) {
            int sum = 0;
            for (Integer i : curr) {
                sum += i;
            }
            if (sum == target) {
                List<Integer> copy = new ArrayList<>();
                copy.addAll(curr);
                result.add(copy);
            }
            return;
        }
        
        if (elements.length - start < step)
            return;
        
        for (int i = start; i < elements.length; i++) {
            curr.add(elements[i]);
            dfs(result, elements, curr, i + 1, step - 1, target);
            curr.remove(curr.size() - 1);
        }
    }
}