/*
    第一个F(0)算出来之后，之后所有的值都可以用之前值推导出来
    F(i) = F(i - 1) + sum - A.length × A[A.length - i]，这里的4就是A的长度
*/

class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            dp[0] += i * A[i];
            sum += A[i];
        }
        int result = dp[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = dp[i - 1] - A.length * A[A.length - i]+ sum;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}