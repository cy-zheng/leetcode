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
    
    private boolean result = false;
    
    public boolean checkEqualTree(TreeNode root) {
        int sum = sum(root, 0);
        result = false;
        sum(root, sum);
        return result;
    }
    
    private int sum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int left = sum(root.left, sum), right = sum(root.right, sum);
        if (left * 2 == sum && root.left != null)
            result = true;
        if (right * 2 == sum && root.right != null)
            result = true;
        return root.val + left + right;
    }
}
