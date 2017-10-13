/*
    map + heap可以搞定
*/

import java.util.*;

class Solution {
    
    class Pair implements Comparable<Pair> {
        char key;
        int cnt;
        public Pair(char key, int cnt) {
            this.key = key;
            this.cnt = cnt;
        }
        
        public int compareTo(Pair other) {
            return other.cnt - this.cnt;
        }
    }
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (char key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }
        
        while (pq.size() > 0) {
            Pair curr = pq.poll();
            for (int i = 0; i < curr.cnt; i++) {
                sb.append(curr.key);
            }
        }
        
        return sb.toString();
    }
}