/*
    dp状态：走到这个格子时，需要的最少血量，大于1
    dp转移方程：下方和右方两个格子，使得当前格子需要血量最少的路径
    dp方向：由右下向左上
*/

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dp.length - 1][dp[0].length - 1] = Math.max(1, -dungeon[dp.length - 1][dp[0].length - 1] + 1);
        for (int i = dp.length - 2; i >= 0; i--)
            dp[i][dp[0].length - 1] = Math.max(1, dp[i + 1][dp[0].length - 1] - dungeon[i][dp[0].length - 1]);
        for (int i = dp[0].length - 2; i >= 0; i--)
            dp[dp.length - 1][i] = Math.max(1, dp[dp.length - 1][i + 1] - dungeon[dp.length - 1][i]);
        
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                dp[i][j] = Math.min(
                    Math.max(1, dp[i + 1][j] - dungeon[i][j]), 
                    Math.max(1, dp[i][j + 1] - dungeon[i][j]));
            }
        }
        return dp[0][0];
    }
}