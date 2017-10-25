/*
    记忆化搜索
*/

import java.util.*;

class Solution {
    
    class Pair {
        int index, target;
        public Pair(int index, int target) {
            this.index = index;
            this.target = target;
        }
        public boolean equals(Object o) {            // 注意equals和hashCode的写法
            if (!(o instanceof Pair))
                return false;
            Pair other = (Pair) o;
            return this.index == other.index && this.target == other.target;
        }
        public int hashCode() {
            return this.target * 20 + this.index;
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Pair, Integer> map = new HashMap<>();
        return dfs(map, nums, 0, S);
    }

    private int dfs(Map<Pair, Integer> map, int[] nums, int start, int target) {
        if (start >= nums.length)
            return target == 0 ? 1 : 0;

        if (map.containsKey(new Pair(start, target)))
            return map.get(new Pair(start, target));

        int result = 0;
        int count1 = dfs(map, nums, start + 1, target - nums[start]);          // 两个分支
        int count2 = dfs(map, nums, start + 1, target + nums[start]);
        result += count1 + count2;
        map.put(new Pair(start, target), result);
        return result;
    }
    
}