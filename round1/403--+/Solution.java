/*
    注意下一次能跳的步数和上一次跳的步数相关
*/

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> sets = new HashMap<>();
        for (int i : stones)
            sets.put(i, new HashSet<>());
        sets.get(stones[0]).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int step : sets.get(stones[i])) {
                if (step - 1 > 0 && sets.containsKey(stones[i] + step - 1))
                    sets.get(stones[i] + step - 1).add(step - 1);
                if (step > 0 && sets.containsKey(stones[i] + step))
                    sets.get(stones[i] + step).add(step);
                if (step + 1 > 0 && sets.containsKey(stones[i] + step + 1))
                    sets.get(stones[i] + step + 1).add(step + 1);
            }
        }
        return sets.get(stones[stones.length - 1]).size() != 0;
    }
}