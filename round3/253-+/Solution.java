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

class Point implements Comparable<Point> {
    int time;
    boolean isStart;
    public Point(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }
    
    public int compareTo(Point other) {
        if (this.time != other.time)
            return this.time - other.time;
        if (this.isStart && !other.isStart)
            return 1;
        if (!this.isStart && other.isStart)
            return -1;
        return 0;
    }
}

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        List<Point> list = new LinkedList<>();
        for (Interval interval : intervals) {
            list.add(new Point(interval.start, true));
            list.add(new Point(interval.end, false));
        }
        Collections.sort(list);
        
        int result = 0, curr = 0;
        for (Point p : list) {
            if (p.isStart) 
                curr += 1;
            else
                curr -= 1;
            result = Math.max(result, curr);
        }
        return result;
    }
}
