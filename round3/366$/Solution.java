/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    这个题提供了一个很好的思路，通常我们做的计算层数都是放在形参依次传递，这样用来从上到下以此标号。
    如果需要从下到上标号，可以放在返回值里面。
*/

import java.util.*;

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }
    
    private int dfs(List<List<Integer>> result, TreeNode root) {
        if (root == null)
            return -1;
        
        int level = 1 + Math.max(dfs(result, root.left), dfs(result, root.right));
        if (result.size() < level + 1) 
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        return level;
    }
}
