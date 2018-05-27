/*
    Find the smallest number in either fronts or backs that is not Mischievous.
    Mischievous指的是两面一样
*/

import java.util.*;

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < fronts.length; i++) {
            if (!set.contains(fronts[i])) {
                list.add(fronts[i]);
            }
            if (!set.contains(backs[i])) {
                list.add(backs[i]);
            }
        }
        Collections.sort(list);
        return list.size() == 0 ? 0 : list.get(0);
    }
}
