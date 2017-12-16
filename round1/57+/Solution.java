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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        for (Interval curr : intervals) {
            if (newInterval == null)   // 插入以后的状态
                result.add(curr);
            else if (curr.end < newInterval.start)  // 还没找到插入点
                result.add(curr);
            else if (curr.start > newInterval.end) {  // 触发插入
                result.add(newInterval);
                result.add(curr);
                newInterval = null;
            }
            else {  // 合并阶段
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
            }
        } 
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }
}
