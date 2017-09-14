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

class SummaryRanges {
    
    private TreeMap<Integer, Interval> map;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val))
            return;
        
        Integer before = map.floorKey(val);
        Integer after = map.higherKey(val);
        
        if (before != null && before != val - 1)
            before = null;
        
        if (after != null && after != val + 1)
            after = null;
        
        Interval beforeInt = null, afterInt = null;
        if (before != null)
            beforeInt = map.get(before);
        if (after != null)
            afterInt = map.get(after);
        
        if (before == null && after == null)
            map.put(val, new Interval(val, val));
        else if (before != null && after == null) {
            beforeInt.end = val;
            map.put(val, beforeInt);
        }
        else if (before == null && after != null) {
            afterInt.start = val;
            map.put(val, afterInt);
        }
        else {
            beforeInt.end = afterInt.end;
            map.put(val, beforeInt);
            for (int i = afterInt.start; i <= afterInt.end; i++) {              // 这一步是有问题的，复杂度可以到O(NlogN)
                map.put(i, beforeInt);
            }
        }
    }
    
    public List<Interval> getIntervals() {
        List<Interval> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (result.size() == 0 || map.get(key) != result.get(result.size() - 1))
                result.add(map.get(key));
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
 
 
 /*
    Discuss的答案就没有上述问题，没有保存所有的点对应的区间，有些点合并后删除了，复杂度O(logN)
 */

 public class SummaryRanges {
    TreeMap<Integer, Interval> tree;

    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if(l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if(h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
}