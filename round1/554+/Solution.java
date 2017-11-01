/*
    使用一个pq记录最小元素
*/

import java.util.*;

class Solution {
    
    class Item implements Comparable<Item> {
        int val, index;
        public Item(int val, int index) {
            this.val = val;
            this.index = index;
        }
        public int compareTo(Item other) {
            return this.val - other.val;
        }
    }
    
    public int leastBricks(List<List<Integer>> wall) {
        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (int i = 0; i < wall.size(); i++) {
            pq.add(new Item(wall.get(i).get(0), i));
            wall.get(i).remove(0);
        }
        
        int result = wall.size();
        while (pq.size() > 0) {
            int currCount = 1;
            Item item = pq.poll();
            if (wall.get(item.index).size() > 0) {
                pq.add(new Item(wall.get(item.index).get(0) + item.val, item.index));
                wall.get(item.index).remove(0);
            }
            while (pq.size() > 0 && pq.peek().val == item.val) {
                currCount++;
                Item tmp = pq.poll();
                if (wall.get(tmp.index).size() > 0) {
                    pq.add(new Item(wall.get(tmp.index).get(0) + tmp.val, tmp.index));
                    wall.get(tmp.index).remove(0);
                }
            } 
            if (pq.size() > 0)
                result = Math.min(result, wall.size() - currCount);
        }
        return result;
    }
}