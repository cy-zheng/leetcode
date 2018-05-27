/*
    记忆化搜索
*/

import java.util.*;

class Solution {
    private Map<String, Double> map = new HashMap<>();
    
    public double largestSumOfAverages(int[] A, int K) {
        int[] sums = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = sums[i] + A[i];
        }
        return dfs(A, sums, 0, A.length - 1, K);
    }
    
    private double dfs(int[] nums, int[] sums, int start, int end, int K) {
        if (map.containsKey(start + "#" + end + "#" + K)) {
            return map.get(start + "#" + end + "#" + K);
        }
        double result = 0;
        if (K == 1) {
            result = (sums[end + 1] - sums[start]) * 1.0 / (end - start + 1);
        }
        else {
            for (int i = start + 1; i <= end - K + 2; i++) {
                result = Math.max(
                    result,
                    (sums[i] - sums[start]) * 1.0 / (i - start) + dfs(nums, sums, i, end, K - 1)
                );
            }
        }
        map.put(start + "#" + end + "#" + K, result);
        return result;
    }
}
