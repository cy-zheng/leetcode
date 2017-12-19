import java.util.*;

class Solution {
    
    class Item implements Comparable<Item> {
        int label, delay;
        public Item(int label, int delay) {
            this.label = label;
            this.delay = delay;
        }
        
        public int compareTo(Item other) {
            return this.delay - other.delay;
        }
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        Set<Integer> remain = new HashSet<>();
        for (int i = 1; i <= N; i++) 
            remain.add(i);
        
        Map<Integer, List<Item>> map = new HashMap<>();
        for (int[] time : times) {
            if (!map.containsKey(time[0]))
                map.put(time[0], new ArrayList<>());
            map.get(time[0]).add(new Item(time[1], time[2]));
        }
        
        PriorityQueue<Item> pq = new PriorityQueue<>();
        pq.add(new Item(K, 0));
        while (pq.size() > 0) {
            Item curr = pq.poll();
            if (!remain.contains(curr.label))
                continue;
            remain.remove(curr.label);
            if (remain.size() == 0)
                return curr.delay;
            
            for (Item child : map.getOrDefault(curr.label, new ArrayList<>())) {
                if (!remain.contains(child.label))
                    continue;
                pq.add(new Item(child.label, curr.delay + child.delay));
            }
        }
        return -1;
    }
}
