class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] r = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                r[i][j] = smooth(M, i, j);
            }
        }
        return r;
    }
    
    private int smooth(int[][] M, int i, int j) {
        long sum = 0;
        int count = 0;
        int[] dx = {1, 1, 1, 0, 0, 0, -1, -1, -1};
        int[] dy = {1, 0, -1, 1, 0, -1, 1, 0, -1};
        for (int k = 0; k < 9; k++) {
            if (test(M, i + dx[k], j + dy[k])) {
                sum += M[i + dx[k]][j + dy[k]];
                count++;
            }
        }
        return (int) (sum / count);
    }
    
    private boolean test(int[][] M, int i, int j) {
        if (i < 0 || j < 0)
            return false;
        if (i >= M.length || j >= M[0].length)
            return false;
        return true;
    }
}
