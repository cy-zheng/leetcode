import java.util.*;

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        
        for (int i = 0; i < pid.size(); i++) {
            if (!map.containsKey(ppid.get(i)))
                map.put(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        List<Integer> result = new ArrayList<>();
        while (queue.size() > 0) {
            int curr = queue.poll();
            result.add(curr);
            for (int next : map.getOrDefault(curr, new ArrayList<>())) {
                queue.add(next);
            }
        }
        return result;
    }
}
