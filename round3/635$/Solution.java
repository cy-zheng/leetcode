/*
    NavigableMap<K,V> TreeMap.subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) 
    返回此映射的部分视图，其键的范围从 fromKey 到 toKey。
*/

import java.util.*;

public class LogSystem {
    private String min, max;
    private HashMap<String, Integer> map;
    private TreeMap<String, LinkedList<Integer>> logs;
    public LogSystem() {
        min = "2000:01:01:00:00:00";
        max = "2017:12:31:23:59:59";
        map = new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
        logs = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        if(!logs.containsKey(timestamp)) logs.put(timestamp, new LinkedList<>());
        logs.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int index = map.get(gra);
        String start = s.substring(0, index)+min.substring(index), end = e.substring(0, index)+max.substring(index);
        NavigableMap<String, LinkedList<Integer>> sub = logs.subMap(start, true, end, true);
        LinkedList<Integer> ans = new LinkedList<>();
        for (Map.Entry<String, LinkedList<Integer>> entry : sub.entrySet()) {
            ans.addAll(entry.getValue());
        }
        return ans;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
