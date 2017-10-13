/*
    用两个pq实现，注意java 8 comparator写法
*/

import java.util.*;

class AllOne {
    
    class Pair{
        String key;
        int value;
        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Map<String, Pair> map;
    private PriorityQueue<Pair> pqMin, pqMax;

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        Comparator<Pair> comparator = (p1, p2) -> p1.value - p2.value;     // 注意这里
        pqMin = new PriorityQueue<>(11, comparator);
        pqMax = new PriorityQueue<>(11, comparator.reversed());
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            Pair p = new Pair(key, 1);
            map.put(key, p);
            pqMin.add(p);
            pqMax.add(p);
        }
        else {
            Pair _old = map.get(key);
            Pair _new = new Pair(key, _old.value + 1);
            map.put(key, _new);
            pqMin.remove(_old);
            pqMin.add(_new);
            pqMax.remove(_old);
            pqMax.add(_new);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key))
            return;
        Pair _old = map.get(key);
        if (_old.value == 1) {
            map.remove(key);
            pqMin.remove(_old);
            pqMax.remove(_old);
        }
        else {
            Pair _new = new Pair(key, _old.value - 1);
            map.put(key, _new);
            pqMin.remove(_old);
            pqMin.add(_new);
            pqMax.remove(_old);
            pqMax.add(_new);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return pqMax.size() == 0 ? "" : pqMax.peek().key;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return pqMin.size() == 0 ? "" : pqMin.peek().key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */