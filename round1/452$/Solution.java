/*
    思路参考：http://bgmeow.xyz/2016/12/30/LeetCode-452/
*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        // 先按起始排序，再按终止排序
        Arrays.sort(points, new Comparator<int[]>() {
           public int compare(int[] o1, int[] o2) {
               if (o1[0] == o2[0]) {
                   return o1[1] - o2[1];
               }
               return o1[0] - o2[0];
           } 

        });

        int minArrows = 1;
        // 左边坐标一定是增大的，可以只判断右边界限就好。
        int rightBound = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // 起始坐标落在交汇范围内，计算新的右界限
            if (points[i][0] <= rightBound) {
                rightBound = Math.min(rightBound, points[i][1]);   // 因为要保证打破之前遍历过的气球，所以选择两个当中较小的
            // 不在原交汇范围
            } else {
                minArrows++;
                rightBound = points[i][1];    // 此处选择右边界，因为右边界最有希望打破更多的气球
            }
        }
        return minArrows;
    }
}