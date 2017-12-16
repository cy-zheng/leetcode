/*
    扫描线
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0)
            return intervals;

        intervals.sort((i1, i2) -> {
            if (i1.start != i2.start)
                return i1.start - i2.start;
            return i1.end - i2.end;
        });
        List<Interval> result = new ArrayList<>();
        Interval curr = intervals.get(0);
        for (int i = 0; i < intervals.size(); i++) {
            if (curr.end < intervals.get(i).start) {
                result.add(new Interval(curr.start, curr.end));
                curr = intervals.get(i);
            }
            else {
                curr.end = Math.max(curr.end, intervals.get(i).end);
            }
        }
        result.add(new Interval(curr.start, curr.end));
        return result;
    }
}
