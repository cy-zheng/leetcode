class Item {
    int up, left, dia, anti;
    Item(int up, int left, int dia, int anti) {
        this.up = up;
        this.left = left;
        this.dia = dia;
        this.anti = anti;
    }
}

public class Solution {
    public int longestLine(int[][] M) {
        int result = 0;
        if (M == null || M.length == 0 || M[0].length == 0)
            return result;
        Item[][] dp = new Item[M.length + 1][M[0].length + 1];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    dp[i + 1][j + 1] = new Item(
                        (dp[i][j + 1] == null ? 0 : dp[i][j + 1].up) + 1,
                        (dp[i + 1][j] == null ? 0 : dp[i + 1][j].left) + 1, 
                        (dp[i][j] == null ? 0 : dp[i][j].dia) + 1, 
                        (j + 2 >= M[0].length || dp[i][j + 2] == null ? 0 : dp[i][j + 2].anti) + 1
                    );
                    
                    result = Math.max(result, dp[i + 1][j + 1].up);
                    result = Math.max(result, dp[i + 1][j + 1].left);
                    result = Math.max(result, dp[i + 1][j + 1].dia);
                    result = Math.max(result, dp[i + 1][j + 1].anti);
                }
            }
        }
        return result;
    }
}
