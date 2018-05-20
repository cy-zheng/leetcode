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
    
    private int minDiff = Integer.MAX_VALUE;
    private Integer pre = null;
    
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minDiff;
    }
    
    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        if (pre != null) {
            minDiff = Math.min(root.val - pre, minDiff);
        }
        pre = root.val;
        dfs(root.right);
    }
}
