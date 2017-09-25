/*
    要记录一个当前节点是父节点的左孩子，还是右孩子
*/

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
    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root, true);
    }
    
    private int getSum(TreeNode root, boolean isRight) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return isRight ? 0 : root.val;
        return getSum(root.left, false) + getSum(root.right, true);
    }
}