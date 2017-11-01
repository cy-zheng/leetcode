/*
    难到爆炸
    dp[i][j][k]的定义是，在i~j区间内，区间左边相邻有k个和i相同颜色的箱子，所能取得的最大得分
    其实这里的dp有一点记忆化搜索的含义了
*/

class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, 0, n - 1, 0, dp);
    }

    private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];

        for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++); // 相当于合并i往后的连续的与i相同的箱子
        int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp); // 第一种情况，消除这k + 1个箱子（加上第i个，所以+1）

        for (int m = i + 1; m <= j; m++) {
            if (boxes[i] == boxes[m]) {
                // 第二种情况，保留第i个箱子，消除i + 1 ~ j（此时i + 1一定和i颜色不同），然后消除i以及前面的k个，加上m后面和i相同颜色的部分
                // Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) 代表着i和m相同，i + 1和m - 1注定和i不同。由于i的存在，k=0
                // removeBoxesSub(boxes, m, j, k + 1, dp) 重叠子问题，消除m~j，左边有k+1个和k相同的箱子
                res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
            }
        }

        dp[i][j][k] = res;
        return res;
    }
}
