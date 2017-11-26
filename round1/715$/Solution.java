/*
    区间类问题经典题目
    使用TreeMap，Inteval表示区间，map的key为区间的左端点
*/

import java.util.*;

class RangeModule {
    private class Interval {
        int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    TreeMap<Integer, Interval> intervals;
    public RangeModule() {
        intervals = new TreeMap<>();
    }
    
    // 插入区间
    public void addRange(int left, int right) {
        if (intervals.containsKey(left)) {
            Interval cur = intervals.get(left);  // 如果带插入区间的左端点和已有区间重合，那么首先合并已有区间，然后循环合并右边的区间
            cur.end = Math.max(cur.end, right);
            Map.Entry<Integer, Interval> high = intervals.higherEntry(cur.start);
            while (high != null) {
                if (high.getKey() > cur.end) break;
                intervals.remove(high.getKey());
                cur.end = Math.max(cur.end, high.getValue().end);
                high = intervals.higherEntry(cur.start);
            }
        } else {
            Interval cur = new Interval(left, right);     // 如果左端点不与任何区间重合，先判断左端点是不是落在了一个区间之内，如果是，需要合并这个区间
            Map.Entry<Integer, Interval> low = intervals.lowerEntry(left);
            if (low != null && low.getValue().end >= cur.start) {
                intervals.remove(low.getKey());
                cur.start = Math.min(cur.start, low.getValue().start);
                cur.end = Math.max(cur.end, low.getValue().end);
            }
            Map.Entry<Integer, Interval> high = intervals.higherEntry(cur.start);  // 像刚才一样，合并右边的区间
            while (high != null) {
                if (high.getKey() > cur.end) break;
                intervals.remove(high.getKey());
                cur.end = Math.max(cur.end, high.getValue().end);
                high = intervals.higherEntry(cur.start);
            }
            intervals.put(cur.start, cur);
        }
    }
    
    public boolean queryRange(int left, int right) {  // 判断left~right有没有被add，分两种情况，左端点重合，左端点被low包含
        if (intervals.containsKey(left)) {
            Interval cur = intervals.get(left);
            return cur.end >= right;
        } else {
            Map.Entry<Integer, Interval> low = intervals.lowerEntry(left);
            return low != null && low.getValue().end >= right;
        }
    }
    
    public void removeRange(int left, int right) { // 删除区间，也分两种情况，左端点重合，左端点被low包含
        if (intervals.containsKey(left)) {
            Interval cur = intervals.get(left);
            while (cur != null) {  // 循环删除high区间，最后有可能删掉了high某个的一半
                if (cur.start >= right) break;
                intervals.remove(cur.start);
                if (right <= cur.end) {
                    cur.start = right;
                    intervals.put(cur.start, cur);
                    break;
                } else {
                    Map.Entry<Integer, Interval> high = intervals.higherEntry(cur.start);
                    cur = high == null ? null : high.getValue();
                }
            }
        } else {
            Map.Entry<Integer, Interval> low = intervals.lowerEntry(left);
            if (low != null) {
                if (right < low.getValue().end) {  // low将left~right完全包含在内
                    intervals.put(right, new Interval(right, low.getValue().end));
                }
                low.getValue().end = Math.min(low.getValue().end, left);
            }
            Map.Entry<Integer, Interval> high = intervals.higherEntry(left);
            Interval cur = high == null ? null : high.getValue();
            while (cur != null) { // 循环合并high
                if (cur.start >= right) break;
                intervals.remove(cur.start);
                if (right <= cur.end) {
                    cur.start = right;
                    intervals.put(cur.start, cur);
                    break;
                } else {
                    high = intervals.higherEntry(cur.start);
                    cur = high == null ? null : high.getValue();
                }
            }
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
