/*
    不能使用模拟的思路去解，TLE
    要找概率分布的规律，就会发现概率分布是前面一个滑动窗口的和/W
*/

class Solution {
    public double new21GameII(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        if (K == 1) {
            return 1.0 * N / W;
        }
        double[][] dp = new double[2][K - 1];
        double result = 0;
        for (int i = 0; i < W; i++) {
            if (i < K - 1)
                dp[0][i] = 1.0 / W;
            if (i + 1 > N)
                result += 1.0 / W;
        }

        for (int i = 0; i < K - 1; i++) {
            for (int j = 0; j < K - 1; j++) {
                dp[(i + 1) % 2][j] = 0;
            }
            for (int j = 0; j < K - 1; j++) {
                for (int k = 0; k < W; k++) {
                    int next = j + 1 + k + 1;
                    double p = dp[i % 2][j] / W;

                    if (next < K)
                        dp[(i + 1) % 2][next - 1] += p;
                    if (next > N)
                        result += p;
                }
            }
        }
        return 1 - result;
    }
    
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) return 1;
        double dp[] = new double[N + 1],  Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K) Wsum += dp[i]; else res += dp[i];
            if (i - W >= 0) Wsum -= dp[i - W];
        }
        return res;
    }
}
