/*
    类似于dfs，1,10,100,101,102,11,12,2这样的顺序
*/

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        if (n < 1) return result;
        for (int i = 1; i <= 9 && i <= n; i++)
            dfs(result, i, n);
        return result;
    }
    
    private void dfs(List<Integer> result, int curr, int n) {
        result.add(curr);
        if (curr * 10 <= n) {
            curr *= 10;
            int i = 0;
            while (i < 10 && curr + i <= n) {
                dfs(result, curr + i, n);
                i++;
            }
        }
    }
}