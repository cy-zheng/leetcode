import java.util.*;

class MyCalendar {
    
    class Interval {
        int left, right;
        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    
    private TreeMap<Integer, Interval> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if (map.containsKey(start))
            return false;
        Integer lower = map.lowerKey(start);
        if (lower != null && map.get(lower).right > start)
            return false;
        Integer higher = map.higherKey(start);
        if (higher != null && higher < end)
            return false;
        map.put(start, new Interval(start, end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
