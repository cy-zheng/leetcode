class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[2][102];
        dp[0][1] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 1; j <= i + 1; j++) {
                double left = dp[(i - 1) % 2][j - 1] > 1 ? (dp[(i - 1) % 2][j - 1] - 1) / 2 : 0;
                double right = dp[(i - 1) % 2][j] > 1 ? (dp[(i - 1) % 2][j] - 1) / 2 : 0;
                dp[i % 2][j] = left + right;
            }
        }
        return Math.min(dp[query_row % 2][query_glass + 1], 1.0);
    }
}
