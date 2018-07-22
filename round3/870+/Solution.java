import java.util.*;

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int a : A) {
            tree.put(a, tree.getOrDefault(a, 0) + 1);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            Integer higher = tree.higherKey(B[i]);
            if (higher == null) {
                Integer lowest = tree.firstKey();
                result[i] = lowest;
                tree.put(lowest, tree.get(lowest) - 1);
                if (tree.get(lowest) == 0)
                    tree.remove(lowest);
            }
            else {
                result[i] = higher;
                tree.put(higher, tree.get(higher) - 1);
                if (tree.get(higher) == 0)
                    tree.remove(higher);
            }
        }
        return result;
    }
}
