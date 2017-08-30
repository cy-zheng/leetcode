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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, 
                            int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart > iEnd)
            return null;
        if (iStart == iEnd)
            return new TreeNode(inorder[iStart]);
        TreeNode result = new TreeNode(postorder[pEnd]);
        int rootIndex = indexOf(inorder, postorder[pEnd]);
        if (rootIndex > iStart) {
            result.left = helper(inorder, postorder, iStart, 
                                 rootIndex - 1, pStart, pStart + rootIndex - iStart - 1);
        }
        if (rootIndex < iEnd) {
            result.right = helper(inorder, postorder, rootIndex + 1, 
                                  iEnd, pStart + rootIndex - iStart, pEnd - 1);
        }
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