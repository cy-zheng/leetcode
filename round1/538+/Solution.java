/*
    dfs返回值是这个子树的和
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
    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }
    
    private int dfs(TreeNode root, int bigger) {
        if (root == null) 
            return 0;
        int right = dfs(root.right, bigger);
        int tmp = right + root.val;
        root.val += right + bigger;
        int left = dfs(root.left, root.val);
        return left + tmp;
    }
}