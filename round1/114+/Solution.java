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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root.right != null)
            root.right = helper(root.right);
        if (root.left != null) {
            root.left = helper(root.left);
            TreeNode cur = root.left;
            while (cur.right != null)
                cur = cur.right;
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return root;
    }
}