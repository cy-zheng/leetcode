import java.util.*;

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            tree.add(flowers[i]);
            Integer lower = tree.lower(flowers[i]);
            if (lower != null && lower + k + 1 == flowers[i])
                return i + 1;
            Integer higher = tree.higher(flowers[i]);
            if (higher != null && flowers[i] + k + 1 == higher)
                return i + 1;
        }
        return -1;
    }
}
