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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd)
            return null;
        if (pStart == pEnd)
            return new TreeNode(preorder[pStart]);
        
        TreeNode result = new TreeNode(preorder[pStart]);
        int inorderIndex = indexOf(inorder, preorder[pStart]);
        if (inorderIndex > iStart) 
            result.left = helper(preorder, inorder, pStart + 1, pStart + inorderIndex - iStart, iStart, inorderIndex - 1);
        if (inorderIndex < iEnd)
            result.right = helper(preorder, inorder, pStart + inorderIndex - iStart + 1, pEnd, inorderIndex + 1, iEnd);
        return result;
        
    }
    
    private int indexOf(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
}