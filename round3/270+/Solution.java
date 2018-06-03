/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Integer result = null;
    
    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return result;
    }
    
    private void dfs(TreeNode root, double target) {
        if (root == null)
            return;
        if (result == null)
            result = root.val;
        else {
            if (Math.abs(result - target) > Math.abs(root.val - target))
                result = root.val;
        }
        
        if (root.val > target)
            dfs(root.left, target);
        else 
            dfs(root.right, target);
    }
}
