/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root, target, k);
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode root, double target, int k) {
        if (root == null)
            return;
        dfs(result, root.left, target, k);
        if (result.size() == k) {
            if (Math.abs(result.get(0) - target) > Math.abs(root.val - target)) {
                result.remove(0);
                result.add(root.val);
            } 
            else
                return;
        }
        else {
            result.add(root.val);
        }
        dfs(result, root.right, target, k);
    }
}
