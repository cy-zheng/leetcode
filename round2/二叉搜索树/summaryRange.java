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
    leetcode 352
    BST简单应用
*/

import java.util.*;

class SummaryRanges {

    private TreeMap<Integer, Interval> tree;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        Integer before = tree.floorKey(val);
        if (before != null && tree.get(before).end >= val)
            return;
        if (before != null && tree.get(before).end < val - 1)
            before = null;

        Integer after = tree.ceilingKey(val);
        if (after != null && after == val)
            return;
        if (after != null && after > val + 1)
            after = null;


        if (before == null && after == null)
            tree.put(val, new Interval(val, val));
        else if (before != null && after == null)
            tree.get(before).end = val;
        else if (before == null && after != null) {
            Interval tmp = tree.get(after);
            tmp.start = val;
            tree.remove(after);
            tree.put(val, tmp);
        }
        else {
            tree.get(before).end = tree.get(after).end;
            tree.remove(after);
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> result = new ArrayList<>();
        for (int key : tree.keySet()) {
            result.add(tree.get(key));
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
