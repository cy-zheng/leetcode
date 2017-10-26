/*
    DFS + 记忆化搜索
*/

import java.util.*;

class Solution {
    
    class Pair {
        int startIndex, ringIndex;
        public Pair(int startIndex, int ringIndex) {
            this.startIndex = startIndex;
            this.ringIndex = ringIndex;
        }
        public boolean equals(Object other) {
            if (!(other instanceof Pair))
                return false;
            Pair p = (Pair) other;
            return this.startIndex == p.startIndex && this.ringIndex == p.ringIndex;
        }
        public int hashCode() {
            return ringIndex * 100 + startIndex;
        }
    }
    
    public int findRotateSteps(String ring, String key) {
        if (key == null || key.length() == 0)
            return 0;
        
        Map<Character, List<Integer>> map = new HashMap<>();
        Map<Pair, Integer> cache = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            if (!map.containsKey(c))
                map.put(c, new ArrayList<>());
            map.get(c).add(i);
        }
        
        return dfs(map, cache, key, ring, 0, 0);
    }
    
    private int dfs(Map<Character, List<Integer>> map, Map<Pair, Integer> cache, 
                    String key, String ring, int startIndex, int ringIndex) {
        if (startIndex >= key.length())
            return 0;
        
        if (cache.containsKey(new Pair(startIndex, ringIndex)))
            return cache.get(new Pair(startIndex, ringIndex));
        
        char c = key.charAt(startIndex);
        int distance = Integer.MAX_VALUE;
        for (int nextIndex : map.get(c)) {
            int curDis = Math.min((ringIndex - nextIndex + ring.length()) % ring.length(),
                                 (nextIndex - ringIndex + ring.length()) % ring.length()) + 1;
            distance = Math.min(distance, curDis + dfs(map, cache, key, ring, startIndex + 1, nextIndex));
        }
        cache.put(new Pair(startIndex, ringIndex), distance);
        return distance;
    }
}
