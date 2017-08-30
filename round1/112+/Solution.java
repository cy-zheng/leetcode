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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return helper(root, sum);
    }
    
    private boolean helper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (root.val == sum)
                return true;
            return false;
        }
        boolean result = false;
        if (root.left != null)
            result = result || helper(root.left, sum - root.val);
        if (root.right != null)
            result = result || helper(root.right, sum - root.val);
        return result;
    }
}