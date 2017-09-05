/*
    对每个节点BFS超时，剪枝也超时
    
    答案一定是最长距离的中间结点位置上。
    我们要的是中间结点，沿着树的外围每次把叶子结点砍掉，那么，最后剩下的就是中间结点
    
    多次遍历节点集合，删除只有一个neighbor的节点，只剩一个或者是两个。
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