/*
    删除BST节点，使用左子树最大节点或右子树最小节点代替当前结点的值
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
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val != key) {
            root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
            return root;
        }
        else {
            int max = findMax(root.left);
            int min = findMin(root.right);
            
            if (max != Integer.MIN_VALUE) {
                root.val = max;
                root.left = deleteNode(root.left, max);
                return root;
            }
            else if (min != Integer.MAX_VALUE) {
                root.val = min;
                root.right = deleteNode(root.right, min);
                return root;
            }
            else {
                return null;
            }
        }
    }
    
    public int findMin(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        while (root.left != null)
            root = root.left;
        return root.val;
    }
    
    public int findMax(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        while (root.right != null)
            root = root.right;
        return root.val;
    }
    
}