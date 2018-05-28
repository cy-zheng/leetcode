/*
    暴力解O(N^4)，下面的解O(A*B)，A、B为1的个数
    为什么要用i / N * 100 + i % N，而不是i呢？
    因为在i - j这一步，如果之前没有使用100做变换，那么存在不同的移动方式能拿到相同的i - j。
    为什么会这样呢？
*/

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; ++i) if (A[i / N][i % N] == 1) LA.add(i / N * 100 + i % N);
        for (int i = 0; i < N * N; ++i) if (B[i / N][i % N] == 1) LB.add(i / N * 100 + i % N);
        for (int i : LA) for (int j : LB)
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;
    }
}
