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
    public TreeNode pruneTree(TreeNode root) {
        if (dfs(root)) {
            return root;
        }
        return null;
    }
    
    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        if (!dfs(root.left)) {
            root.left = null;
        }
        if (!dfs(root.right)) {
            root.right = null;
        }
        return !(root.left == null && root.right == null && root.val == 0);
    }
}
