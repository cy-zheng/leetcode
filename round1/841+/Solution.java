import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(0);
        queue.add(0);
        while (queue.size() > 0) {
            int curr = queue.poll();
            for (int next : rooms.get(curr)) {
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
