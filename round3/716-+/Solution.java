import java.util.*;

class MaxStack {
    
    private TreeMap<Integer, List<Integer>> map;
    private List<Integer> list;

    /** initialize your data structure here. */
    public MaxStack() {
        this.map = new TreeMap<>();
        this.list = new LinkedList<>();
    }
    
    public void push(int x) {
        if (!map.containsKey(x))
            map.put(x, new LinkedList<>());
        map.get(x).add(list.size());
        list.add(x);
    }
    
    public int pop() {
        int val = list.get(list.size() - 1);
        List<Integer> tmpList = map.getOrDefault(val, new ArrayList<>());
        while (tmpList.size() == 0 || list.size() - 1 != tmpList.get(tmpList.size() - 1)) {
            list.remove(list.size() - 1);
            val = list.get(list.size() - 1);
            tmpList = map.getOrDefault(val, new ArrayList<>());
        }
        list.remove(list.size() - 1);
        map.get(val).remove(map.get(val).size() - 1);
        if (map.get(val).size() == 0)
            map.remove(val);
        return val;
    }
    
    public int top() {
        int val = list.get(list.size() - 1);
        List<Integer> tmpList = map.getOrDefault(val, new ArrayList<>());
        while (tmpList.size() == 0 || list.size() - 1 != tmpList.get(tmpList.size() - 1)) {
            list.remove(list.size() - 1);
            val = list.get(list.size() - 1);
            tmpList = map.getOrDefault(val, new ArrayList<>());
        }
        return val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int val = map.lastKey();
        map.get(val).remove(map.get(val).size() - 1);
        if (map.get(val).size() == 0)
            map.remove(val);
        return val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
