/*
    使用heap保存List，确保最短的List先被选择
*/

import java.util.*;

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<List<Integer>>> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                List<Integer> curr = new ArrayList<>();
                curr.add(n);
                PriorityQueue<List<Integer>> parent = map.getOrDefault(n + 1, 
                        new PriorityQueue<>(11, Comparator.comparingInt(List::size)));
                parent.add(curr);
                map.put(n + 1, parent);
            }
            else {
                List<Integer> curr = map.get(n).poll();
                map.get(n).remove(0);
                if (map.get(n).size() == 0)
                    map.remove(n);
                curr.add(n);
                PriorityQueue<List<Integer>> parent = map.getOrDefault(n + 1, 
                        new PriorityQueue<>(11, Comparator.comparingInt(List::size)));
                parent.add(curr);
                map.put(n + 1, parent);
            }
        }

        for (int key : map.keySet()) {
            for (List<Integer> list : map.get(key)) {
                if (list.size() < 3)
                    return false;
            }
        }

        return true;
    }
}
