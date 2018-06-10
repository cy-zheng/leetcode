import java.util.*;

class Item {
    int pre = 0;
    List<Integer> next = new ArrayList<>();
}

public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Item> map = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (!map.containsKey(seq.get(i))) {
                    map.put(seq.get(i), new Item());
                }
                if (i != seq.size() - 1) {
                    if (!map.containsKey(seq.get(i + 1))) {
                        map.put(seq.get(i + 1), new Item());
                    }
                    map.get(seq.get(i)).next.add(seq.get(i + 1));
                    map.get(seq.get(i + 1)).pre += 1;
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key).pre == 0)
                queue.add(key);
        }
        int index = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            if (size != 1) return false;
            int curr = queue.poll();
            if (index >= org.length || org[index] != curr) return false;
            index += 1;
            for (int next : map.get(curr).next) {
                map.get(next).pre -= 1;
                if (map.get(next).pre == 0) {
                    queue.add(next);
                }
            }
        }
        return index == org.length && index == map.size();
    }
}
