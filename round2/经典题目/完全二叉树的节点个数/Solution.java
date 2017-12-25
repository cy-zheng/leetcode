/*
    leetcode 222
    此题要用分治的思想
    如果从某节点一直向左的高度 = 一直向右的高度, 那么以该节点为root的子树一定是complete binary tree. 而 complete binary tree的节点数,可以用公式算出 2^h - 1. 如果高度不相等, 则递归调用 return countNode(left) + countNode(right) + 1.  复杂度为O(h^2)   
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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int leftLevel = 1, rightLevel = 1;
        TreeNode left = root.left, right = root.right;
        while (left != null) {
            leftLevel++;
            left = left.left;
        }
        while (right != null) {
            rightLevel++;
            right = right.right;
        }
        if (leftLevel == rightLevel)
            return (1 << (leftLevel)) - 1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
