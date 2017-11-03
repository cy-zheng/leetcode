/*
    三维dp，可以用滚动数组优化掉一维
    思路是：每个格子这一次的路径数 = 上一次四周格子路径数的和
*/

class Solution {
    public int findPaths(int m, int n, int N, int ii, int jj) {
        if (N <= 0)
            return 0;

        int[][][] dp = new int[2][m][n];
        for (int i = 0; i < m; i++) {
            dp[1][i][0]++;
            dp[1][i][n - 1]++;
        }
        for (int i = 0; i < n; i++) {
            dp[1][0][i]++;
            dp[1][m - 1][i]++;
        }
        int result = dp[1][ii][jj];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int k = 2; k <= N; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[k % 2][i][j] = 0;
                    for (int c = 0; c < 4; c++) {
                        int x = i + dx[c];
                        int y = j + dy[c];
                        if (x >= 0 && y >= 0 && x < m && y < n) {
                            dp[k % 2][i][j] += dp[(k - 1) % 2][x][y];
                            dp[k % 2][i][j] %= 1000000007;
                        }
                    }
                }
            }
            result += dp[k % 2][ii][jj];
            result %= 1000000007;
        }
        return result;
    }
}