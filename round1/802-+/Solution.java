/*
    dfs + 记忆化搜索
*/

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] safe = new boolean[graph.length];
        boolean[] hasCache = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (isSafe(graph, i, safe, hasCache)) {
                result.add(i);
            }
        }
        Collections.sort(result);
        return result;
    }
    
    private boolean isSafe(int[][] graph, int start, boolean[] safe, boolean[] hasCache) {
        if (hasCache[start]) {
            return safe[start];
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        boolean result = dfs(graph, start, visited, safe, hasCache);
        hasCache[start] = true;
        safe[start] = result;
        return result;
    }
    
    private boolean dfs(int[][] graph, int start, Set<Integer> visited, boolean[] safe, boolean[] hasCache) {
        if (hasCache[start]) {
            return safe[start];
        }
        for (int next : graph[start]) {
            if (visited.contains(next)) {
                hasCache[start] = true;
                safe[start] = false;
                return false;
            } 
            visited.add(next);
            if (!dfs(graph, next, visited, safe, hasCache)) {
                hasCache[start] = true;
                safe[start] = false;
                return false;
            }
            visited.remove(next);
        }
        hasCache[start] = true;
        safe[start] = true;
        return true;
    }
}
