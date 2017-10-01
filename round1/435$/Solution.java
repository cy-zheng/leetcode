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
    贪心
    http://bookshadow.com/weblog/2016/10/30/leetcode-non-overlapping-intervals/
*/

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.end == i2.end ? i1.start - i2.start : i1.end - i2.end);
        int end = Integer.MIN_VALUE;
        int ans = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end) {
                end = interval.end;
                ans++;
            }
        }
        return intervals.length - ans;
    }
}