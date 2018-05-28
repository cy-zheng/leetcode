/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
    蛮奇怪的一道题，首先树的定义是左倾斜树（所有right节点，一定和left节点父节点相同）
                         Root                   L
                         /  \                  /  \
                        L    R                R   Root
    大概的变换就是上边这样，先变右子树，然后左子树，需要保存左子树的root作为最终结果，然后旋转当前3个节点
*/

class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) 
            return null;
        if (root.left == null && root.right == null)
            return root;
        upsideDownBinaryTree(root.right);
        TreeNode result = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return result;
    }
}
