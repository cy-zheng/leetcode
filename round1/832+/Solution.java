class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int m = 0, n = A[i].length - 1;
            while (m < n) {
                int tmp = A[i][n];
                A[i][n] = A[i][m];
                A[i][m] = tmp;
                m += 1;
                n -= 1;
            }
            for (int j = 0; j < A[i].length; j++) 
                A[i][j] = A[i][j] ^ 1;
        }
        return A;
    }
}
