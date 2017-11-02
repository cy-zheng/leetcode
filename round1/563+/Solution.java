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
    
    private int result;
    
    public int findTilt(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }
    
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        result += Math.abs(right - left);
        return left + right + root.val;
    }
}