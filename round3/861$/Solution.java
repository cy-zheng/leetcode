/*
    Assume A is M * N.

    A[i][0] is worth 1 << (N - 1) points, more than the sum of (A[i][1] + .. + A[i][N-1]).
    We need to toggle all A[i][0] to 1, here I toggle all lines for A[i][0] = 0.
    A[i][j] is worth 1 << (N - 1 - j)
    For every col, I count the current number of 1s.
    After step 1, A[i][j] becomes 1 if A[i][j] == A[i][0].
    if M - cur > cur, we can toggle this column to get more 1s.
    max(M, M - cur) will be the maximum number of 1s that we can get.
*/

class Solution {
    public int matrixScore(int[][] A) {
        // 可以把第一列所有的都变成1，res加上第一列的和
        int M = A.length, N = A[0].length, res = (1 << (N - 1)) * M;
        for (int j = 1; j < N; j++) {
            // 开始调整这一列
            int cur = 0;
            // 如果这个元素与A[i][0]相同，那么当前为1
            for (int i = 0; i < M; i++) cur += A[i][j] == A[i][0] ? 1 : 0;
            // 可以调整这一列，使得1的个数为cur或M - cur
            res += Math.max(cur, M - cur) * (1 << (N - j - 1));
        }
        return res;
    }
}
