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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root);
    }
    
    private int helper(TreeNode root) {
        if (root.left == null && root.right == null)
            return 1;
        int left = root.left != null ? helper(root.left) : Integer.MAX_VALUE;
        int right = root.right != null ? helper(root.right) : Integer.MAX_VALUE;
        return Math.min(left, right) + 1;
    }
}