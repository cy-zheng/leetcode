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
    
    boolean find = false;
    TreeNode result = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return result;
    }
    
    private void dfs(TreeNode root, TreeNode p) {
        if (root == null)
            return;
        dfs(root.left, p);
        if (root.val == p.val)
            find = true;
        else if (find && result == null)
            result = root;
        dfs(root.right, p);
    }
}
