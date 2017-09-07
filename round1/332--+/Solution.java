/*
    先对目的地排序，按照字母顺序遍历，发现第一个直接返回
    Comparable<Pair>需要override public int compareTo(Pair p2)
    Comparator<T>需要override public int compare(T o1, T o2) 
*/

import java.util.*;

class Solution {
    
    class Pair implements Comparable<Pair>{
        int index;
        String to;
        public Pair(int index, String to) {
            this.index = index;
            this.to = to;
        }
        
        public int compareTo(Pair p2) {
            return this.to.compareTo(p2.to);
        } 
    }
    
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0)
            return new ArrayList<String>();
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0]))
                map.put(tickets[i][0], new ArrayList<>());
            if (!map.containsKey(tickets[i][1]))
                map.put(tickets[i][1], new ArrayList<>());
            map.get(tickets[i][0]).add(new Pair(i, tickets[i][1]));
        }
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        boolean[] used = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("JFK");
        dfs(map, "JFK", path, tickets, used);
        return path;
    }
    
    private boolean dfs(Map<String, List<Pair>> map, String curr, List<String> path, String[][] tickets, boolean[] used) {
        if (path.size() == tickets.length + 1) {
            return true;
        }
        
        for (Pair to : map.get(curr)) {
            if (!used[to.index]) {
                used[to.index] = true;
                path.add(to.to);
                boolean tmp = dfs(map, to.to, path, tickets, used);
                if (tmp)
                    return true;
                path.remove(path.size() - 1);
                used[to.index] = false;
            }
        }
        return false;
    }
}