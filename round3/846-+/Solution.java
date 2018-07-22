import java.util.*;

public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0)
            return false;
        if (W == 1)
            return true;
        Arrays.sort(hand);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int m : hand) {
            if (!map.containsKey(m - 1)) {
                if (!map.containsKey(m))
                    map.put(m, new LinkedList<>());
                map.get(m).add(W - 1);
            }
            else {
                int last = map.get(m - 1).remove(0);
                if (map.get(m - 1).size() == 0)
                    map.remove(m - 1);
                if (last - 1 != 0) {
                    if (!map.containsKey(m))
                        map.put(m, new LinkedList<>());
                    map.get(m).add(last - 1);
                }
            }
        }
        return map.size() == 0;
    }
}
