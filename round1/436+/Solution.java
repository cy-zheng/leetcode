/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
/*
    排序 + 二分
*/
 
class Solution {
    
    class Pair implements Comparable<Pair> {
        int index, start;
        public Pair(int index, int start) {
            this.index = index;
            this.start = start;
        }
        public int compareTo(Pair other) {
            if (this.start != other.start)
                return this.start - other.start;
            return this.index - other.index;
        }
    }
    
    public int[] findRightInterval(Interval[] intervals) {
        List<Pair> ints = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++)
            ints.add(new Pair(i, intervals[i].start));
        Collections.sort(ints);
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int left = 0, right = intervals.length - 1;
            while (left + 1 < right) {
                int mid = (right - left) / 2 + left;
                if (ints.get(mid).start < intervals[i].end)
                    left = mid;
                else
                    right = mid;
            }
            if (ints.get(left).start >= intervals[i].end)
                result[i] = ints.get(left).index;
            else if (ints.get(right).start >= intervals[i].end)
                result[i] = ints.get(right).index;
            else
                result[i] = -1;
        }
        return result;
    }
}