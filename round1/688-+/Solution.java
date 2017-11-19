import java.util.*;

class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[] dx = {2, -2, 2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, -1, 1, 2, -2, -2, 2};
        double[][][] dp = new double[2][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[0][i][j] = 1;
            }
        }
        
        for (int step = 1; step <= K; step++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[step % 2][i][j] = 0;
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            dp[step % 2][i][j] += (1.0 / 8) * dp[(step - 1) % 2][nx][ny]; 
                        }
                    }
                }
            }
        }
        return dp[K % 2][r][c];
    }
}
