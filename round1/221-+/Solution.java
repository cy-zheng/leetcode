class Solution {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;
        int[][] left = new int[matrix.length][matrix[0].length];
        int[][] up = new int[matrix.length][matrix[0].length];
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            left[i][0] = matrix[i][0] == '1' ? 1 : 0;
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            result = Math.max(result, dp[i][0]);
            if (i == 0)
                up[i][0] = matrix[i][0] == '1' ? 1 : 0;
            else
                up[i][0] = (matrix[i][0] == '1' ? 1 + up[i - 1][0] : 0);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            up[0][j] = matrix[0][j] == '1' ? 1 : 0;
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            result = Math.max(result, dp[0][j]);
            if (j == 0)
                left[0][j] = matrix[0][j] == '1' ? 1 : 0;
            else
                left[0][j] = (matrix[0][j] == '1' ? 1 + left[0][j - 1] : 0);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = 1 + left[i][j - 1];
                    up[i][j] = 1 + up[i - 1][j];
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(left[i][j], up[i][j]));
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}