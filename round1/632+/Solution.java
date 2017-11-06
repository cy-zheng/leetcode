/*
    类似于多路归并的思想，每一路保持有一个元素，求最小值最大值
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
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Item> pq = new PriorityQueue<>();
        int maxValue = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int[] result = null;
        for (int i = 0; i < nums.size(); i++) {
            maxValue = Math.max(nums.get(i).get(0), maxValue);
            pq.add(new Item(nums.get(i).get(0), i));
            nums.get(i).remove(0);
        }
        if (maxValue - pq.peek().val < minDiff) {
            minDiff = maxValue - pq.peek().val;
            result = new int[] {pq.peek().val, maxValue};
        }
        
        while (pq.size() > 0) {
            Item curr = pq.poll();
            if (nums.get(curr.index).size() == 0)
                return result;
            pq.add(new Item(nums.get(curr.index).get(0), curr.index));
            maxValue = Math.max(maxValue, nums.get(curr.index).get(0));
            nums.get(curr.index).remove(0);
            if (maxValue - pq.peek().val < minDiff) {
                minDiff = maxValue - pq.peek().val;
                result = new int[] {pq.peek().val, maxValue};
            }
        }
        return result;
    }
}