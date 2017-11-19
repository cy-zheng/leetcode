/*
    不要把这个题想成一个数据流求TOP K，数据流求TOP K涉及到更新heap内元素value的情况。
    这道题先遍历一次，求出count就可以
*/

import java.util.*;

class Solution {
    
    class Item implements Comparable<Item> {
        String word;
        int count;
        public Item(String word, int count) {
            this.word = word;
            this.count = count;
        }
        public int compareTo(Item other) {
            if (this.count != other.count)
                return this.count - other.count;
            return other.word.compareTo(this.word);
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (String key : map.keySet()) {
            pq.add(new Item(key, map.get(key)));
            if (pq.size() > k)
                pq.poll();
        }
        
        List<String> result = new ArrayList<>();
        while (pq.size() != 0) {
            result.add(pq.poll().word);
        }
        Collections.reverse(result);
        return result;
    }
}
