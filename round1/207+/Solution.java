import java.util.*;

class Node {
    int pre;
    Set<Integer> next;
    Node() {
        pre = 0;
        next = new HashSet<>();
    }
}

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new Node());
        }
        
        for (int[] p : prerequisites) {
            map.get(p[0]).pre++;
            map.get(p[1]).next.add(p[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (map.get(i).pre == 0) {
                queue.offer(i);
                visited.add(i);
            }
        }
        Node cur;
        int cnt = 0;
        while (queue.size() > 0) {
            cur = map.get(queue.poll());
            cnt++;
            for (int i : cur.next) {
                map.get(i).pre--;
                if (!visited.contains(i) && map.get(i).pre == 0) {
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
        return cnt == numCourses;
    }
}