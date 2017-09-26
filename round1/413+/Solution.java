/*
    dp做法是时间N^2，空间N^2的
    存在时间O(N)，空间O(1)的做法
    见http://blog.csdn.net/camellhf/article/details/52824234
*/

// dp

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        boolean[][] dp = new boolean[A.length][A.length];
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 2; j < A.length; j++) {
                if (j == i + 2 && A[j] - A[j - 1] == A[j - 1] - A[i]) {
                    dp[i][j] = true;
                    result++;
                }
                else if (j > i + 2 && dp[i][j - 1] && A[j] - A[j - 1] == A[j - 1] - A[j - 2]) {
                    dp[i][j] = true;
                    result++;
                }
                else
                    break;
            }
        }
        return result;
    }
}

// O(N)

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int addend = 0;

        for (int i = 2; i < A.length; i++)
            if (A[i - 1] - A[i] == A[i - 2] - A[i - 1])
                count += ++addend;
            else 
                addend = 0;

        return count;
    }
}