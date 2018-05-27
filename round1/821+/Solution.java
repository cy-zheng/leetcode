import java.util.*;

class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        list.add(Integer.MAX_VALUE);
        int[] result = new int[S.length()];
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (list.get(index + 1) == i) {
                index += 1;
            }
            result[i] = (int) Math.min(
                Math.abs(i - (long) list.get(index)), 
                Math.abs(i - (long) list.get(index + 1))
            );
        }
        return result;
    }
}
