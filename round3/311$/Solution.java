/*
    有点tricky，直接循环就不行，多两个判断就行了，因为乘法的时间复杂度太大？
*/

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int Am = A.length, An = A[0].length;
        int Bm = B.length, Bn = B[0].length;
        int[][] result = new int[Am][Bn];
        for (int i = 0; i < Am; i++) {
            for (int k = 0; k < An; k++) {
                if (A[i][k] == 0)
                    continue;
                for (int j = 0; j < Bn; j++) {
                    if (B[k][j] == 0)
                        continue;
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}
