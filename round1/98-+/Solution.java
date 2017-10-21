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
    
    class Result {
        int min, max;
        boolean valid;
        public Result(int min, int max, boolean valid) {
            this.min = min;
            this.max = max;
            this.valid = valid;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return checkBST(root).valid;
    }
    
    private Result checkBST(TreeNode root) {
        Result result = new Result(root.val, root.val, true);
        if (root.left != null) {
            Result left = checkBST(root.left);
            if (left.max >= root.val || !left.valid) {
                result.valid = false;
                return result;
            }
            else {
                result.min = left.min;
            }
        }
        if (root.right != null) {
            Result right = checkBST(root.right);
            if (right.min <= root.val || !right.valid) {
                result.valid = false;
                return result;
            }
            else {
                result.max = right.max;
            }
        }
        return result;
    }
}