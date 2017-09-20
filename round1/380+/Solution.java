/*
    O(1)删除用map，随机访问用ArrayList
    ArrayList的O(1)删除，先用待删元素替换list最末尾元素，然后删除最末尾元素，O(1)
*/

import java.util.*;

class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            if (map.get(val) != list.size() - 1) {
                map.put(list.get(list.size() - 1), map.get(val));
                list.set(map.get(val), list.get(list.size() - 1));
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */