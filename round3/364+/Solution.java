/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*;

class Solution {
    
    int maxDepth = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            dfs(n, 0);
        }
        int result = 0;
        for (int key : map.keySet()) {
            result += map.get(key) * (maxDepth + 1 - key);
        }
        return result;
    }
    
    private void dfs(NestedInteger n, int level) {
        maxDepth = Math.max(level, maxDepth);
        if (n.isInteger()) {
            map.put(level, map.getOrDefault(level, 0) + n.getInteger());
            return;
        }
        else {
            for (NestedInteger c : n.getList()) {
                dfs(c, level + 1);
            }
        }
    }
}
