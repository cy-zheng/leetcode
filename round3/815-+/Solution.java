import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                if (!map.containsKey(j))
                    map.put(j, new ArrayList<>());
                map.get(j).add(i);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> busSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        set.add(S);
        queue.add(S);
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int _ = 0; _ < size; _++) {
                int curr = queue.poll();
                if (curr == T) 
                    return step;
                for (int busIndex : map.getOrDefault(curr, new ArrayList<>())) {
                    if (busSet.contains(busIndex))
                        continue;
                    busSet.add(busIndex);
                    for (int next : routes[busIndex]) {
                        if (!set.contains(next)) {
                            set.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
            step += 1;
        }
        return -1;
    }
}
