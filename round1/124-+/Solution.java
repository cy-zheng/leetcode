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
    
    private int result = Integer.MIN_VALUE;
    
    // 开始和结尾都可以是任意一个节点
    public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left < 0)        // 如果一个分支的和小于0，那么就不要这个分支了
            left = 0;
        if (right < 0)
            right = 0;
        result = Math.max(result, left + root.val + right);   // 最大值可以是root到两边的一条路径
        return Math.max(left, right) + root.val;      // 对于上层节点来说，root向下的路径只能有一条
    }
}