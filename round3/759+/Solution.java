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

class MyInterval implements Comparable<MyInterval> {
    int start;
    int end;
    int index;
    MyInterval(int s, int e, int i) { start = s; end = e; index = i;}
    
    public int compareTo(MyInterval other) {
        if (this.start != other.start)
            return this.start - other.start;
        return other.end - this.end;
    }
}

public class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<MyInterval> pq = new PriorityQueue<>();
        int[] index = new int[schedule.size()];
        for (int i = 0; i < schedule.size(); i++) {
            if (index[i] < schedule.get(i).size()) {
                pq.add(new MyInterval(
                    schedule.get(i).get(index[i]).start, 
                    schedule.get(i).get(index[i]).end, 
                    i
                ));
                index[i] += 1;
            }
        }
        
        Integer last = null;
        List<Interval> result = new ArrayList<>();
        while (pq.size() > 0) {
            MyInterval myInterval = pq.poll();
            if (last == null || myInterval.start <= last) {
                last = Math.max(myInterval.end, last == null ? -1 : last);
            }
            else {
                result.add(new Interval(last, myInterval.start));
                last = Math.max(myInterval.end, last);
            }
            
            if (index[myInterval.index] < schedule.get(myInterval.index).size()) {
                pq.add(new MyInterval(
                    schedule.get(myInterval.index).get(index[myInterval.index]).start,
                    schedule.get(myInterval.index).get(index[myInterval.index]).end,
                    myInterval.index
                ));
                index[myInterval.index] += 1;
            }
        }
        return result;
    }
}
