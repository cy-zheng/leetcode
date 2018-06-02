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
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start)
                    return i1.start - i2.start;
                return i1.end - i2.end;
            }
        });
        int latest = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (interval.start < latest)
                return false;
            latest = Math.max(latest, interval.end);
        }
        return true;
    }
}
