/*
    注意处理null pointer exception
*/

import java.util.*;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0]))
                map.put(edge[0], new LinkedList<>());
            if (!map.containsKey(edge[1]))
                map.put(edge[1], new LinkedList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        queue.add(0);
        visited.add(0);
        
        while (queue.size() > 0) {
            int curr = queue.poll();
            for (int next : map.getOrDefault(curr, new LinkedList<>())) {
                if (visited.contains(next))
                    continue;
                visited.add(next);
                queue.add(next);
            }
        }
        return visited.size() == n;
    }
}
