import java.util.*;

class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i]))
                map.put(B[i], new ArrayList<>());
            map.get(B[i]).add(i);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = map.get(A[i]).get(0);
            map.get(A[i]).remove(0);
        }
        return result;
    }
}
