/*
    TreeMap 与 PriorityQueue 的综合运用
*/

import java.util.*;

class Solution {
    
    class Item implements Comparable<Item> {
        int profit, capital;
        public Item(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
        public int compareTo(Item other) {
            return other.profit - this.profit;
        }
    }
    
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        TreeMap<Integer, List<Item>> map = new TreeMap<>();
        for (int i = 0; i < Profits.length; i++) {
            Item item = new Item(Profits[i], Capital[i]);
            if (!map.containsKey(item.capital))
                map.put(item.capital, new ArrayList<>());
            map.get(item.capital).add(item);
        }
        
        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (int i = k; i > 0; i--) {
            Integer key = map.floorKey(W);
            while (key != null) {
                for (Item item : map.get(key)) 
                    pq.add(item);
                
                map.remove(key);
                key = map.floorKey(W);
            }
            
            if (pq.size() != 0) {
                Item curr = pq.poll();
                W += curr.profit;
            }
        }
        return W;
    }
}
