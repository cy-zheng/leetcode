/*
    leetcode 310
    假如只有一条路径，那么形成最矮的树，就是两根指针找中点
    有多条路径时也是一样，每一次删除叶子节点，只留下一个或者两个节点，这两个节点就是根
*/

import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        while (map.size() > 2) {
            List<Integer> toDelete = new ArrayList<>();
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() == 1) {
                    toDelete.add(entry.getKey());
                }
            }
            for (int d : toDelete) {
                for (int neighbor : map.get(d)) {
                    map.get(neighbor).remove(d);
                }
                map.remove(d);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            result.add(entry.getKey());
        }
        return result;
    }
}
