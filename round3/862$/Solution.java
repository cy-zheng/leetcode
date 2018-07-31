/*
    deque中保存的是prefix上升的一段下标。
    1、B[i] - B[d.getFirst()] >= K时，pollLeft是因为最左边元素，和剩下的元素组成的任何pair都比长度当前要大
    2、第二个while是为了维持上升态势
*/

import java.util.*;

class Solution {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] = B[i] + A[i];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >= K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()]) d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
}
