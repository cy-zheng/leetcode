/*
    sliding window
*/

import java.util.*;

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0, end = 0;
        while (start < S.length() && end < S.length()) {
            while (end < S.length() && S.charAt(end) == S.charAt(start))
                end += 1;
            if (end - start >= 3) {
                List<Integer> curr = new ArrayList<>();
                curr.add(start);
                curr.add(end - 1);
                result.add(curr);
            }
            start = end;
        }
        return result;
    }
}
