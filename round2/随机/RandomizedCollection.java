/*
    leetcode 381
    与380很像，元素可以重复
    map中存的是这个元素的所有下标，删除就随机删一个
*/

import java.util.*;

class RandomizedCollection {
    
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map; 

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
        else {
            map.put(val, new HashSet());
            map.get(val).add(list.size());
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);
        if (map.get(val).size() == 0)
            map.remove(val);
        if (removeIndex != list.size() - 1 && list.size() > 1) {
            map.get(list.get(list.size() - 1)).remove(list.size() - 1);
            list.set(removeIndex, list.get(list.size() - 1));
            map.get(list.get(list.size() - 1)).add(removeIndex);
        }
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
