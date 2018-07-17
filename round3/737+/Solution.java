import java.util.*;

class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0]))
                map.put(pair[0], new HashSet<>());
            map.get(pair[0]).add(pair[1]);
            if (!map.containsKey(pair[1]))
                map.put(pair[1], new HashSet<>());
            map.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            Set<String> set = bfs(map, words1[i]);
            if (!set.contains(words2[i])) {
                return false;
            }
        }
        return true;
    }
    
    private Set<String> bfs(Map<String, Set<String>> map, String s) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(s);
        set.add(s);
        while (queue.size() > 0) {
            String curr = queue.poll();
            for (String next : map.getOrDefault(curr, new HashSet<>())) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
        return set;
    }
}
