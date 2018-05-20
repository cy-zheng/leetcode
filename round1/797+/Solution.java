import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        List<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(result, path, visited, 0, graph);
        return result;
    }
    
    private void dfs(List<List<Integer>> results, List<Integer> path, Set<Integer> visited, int curr, int[][] graph) {
        if (curr == graph.length - 1) {
            results.add(new LinkedList<>(path));
            return;
        }
        
        for (int next : graph[curr]) {
            if (!visited.contains(next)) {
                visited.add(next);
                path.add(next);
                dfs(results, path, visited, next, graph);
                path.remove(path.size() - 1);
                visited.remove(next);
            }
        }
    }
}
