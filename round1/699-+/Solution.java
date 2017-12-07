/*
    每个矩形都要保存一下上边界的高度，这样方便新来的矩阵计算
    整体思路就是遍历，判断两个矩形是否重合，重合新的矩形高度就往上提升
*/

import java.util.*;

class Solution {
    class Interval {
        int start, end, height;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            this.height = end - start;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int[] position : positions) {
            Interval curr = new Interval(position[0], position[0] + position[1]);
            int max = 0;
            for (Interval interval : intervals) {
                if (!(interval.end <= curr.start || interval.start >= curr.end)) {
                    curr.height = Math.max(curr.height, interval.height + curr.end - curr.start);
                }
                max = Math.max(interval.height, max);
            }
            max = Math.max(curr.height, max);
            intervals.add(curr);
            result.add(max);
        }
        return result;
    }
}
