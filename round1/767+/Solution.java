/*
    贪心 + 堆
    每次选择频数最高的字母，如果重复了就选择下一个
*/

import java.util.*;

class Item implements Comparable<Item> {
    char word;
    int count;
    public Item(char word, int count) {
        this.word = word;
        this.count = count;
    }
    
    public int compareTo(Item other) {
        return other.count - this.count;
    }
}

public class Solution {
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        PriorityQueue<Item> pq = new PriorityQueue<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (char key : map.keySet()) {
            pq.add(new Item(key, map.get(key)));
        }
        
        StringBuilder result = new StringBuilder();
        while (pq.size() != 0) {
            Item curr = pq.poll();
            if (result.length() == 0 || result.charAt(result.length() - 1) != curr.word) {
                result.append(curr.word);
                curr.count -= 1;
                if (curr.count != 0) {
                    pq.add(curr);
                }
            }
            else {
                if (pq.size() == 0)
                    return "";
                else {
                    Item next = pq.poll();
                    result.append(next.word);
                    next.count -= 1;
                    if (next.count != 0) {
                        pq.add(next);
                    }
                    pq.add(curr);
                }
            }
        }
        return result.toString();
    }
}
