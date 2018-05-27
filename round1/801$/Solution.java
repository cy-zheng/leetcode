// https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119830/Python-14-line-O(1)-space-O(n)-time-DP-solution
// A[i]>A[i-1] and B[i]>B[i-1] 和 A[i]>B[i-1] and B[i]>A[i-1]是最终两个数组都严格有序时，存在的两个基本情况

class Solution {
    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[1000];
        int[] not_swap = new int[1000];
        swap[0] = 1;
        for (int i = 1; i < N; ++i) {
            not_swap[i] = swap[i] = N;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                not_swap[i] = not_swap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                not_swap[i] = Math.min(not_swap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], not_swap[i - 1] + 1);
            }
        }
        return Math.min(swap[N - 1], not_swap[N - 1]);
    }
}
