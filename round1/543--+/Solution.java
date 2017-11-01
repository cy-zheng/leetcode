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
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        result = 0;
        dfs(root);
        return result - 1;
    }
    
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }
}