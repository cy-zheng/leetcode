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
        int min, max, r;
        public Result(int min, int max, int r) {
            this.min = min;
            this.max = max;
            this.r = r;
        }
    }
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return -1;
        return dfs(root).r;
    }
    
    private Result dfs(TreeNode root) {
        Result left = null, right = null;
        if (root.left != null)
            left = dfs(root.left);
        if (root.right != null)
            right = dfs(root.right);
        if (left != null && right != null)
            return new Result(left.min, right.max, 
                              Math.min(left.r, 
                                       Math.min(right.r, 
                                                Math.min(right.min - root.val, root.val - left.max))));
        else if (left != null)
            return new Result(left.min, root.val, 
                              Math.min(left.r, root.val - left.max));
        else if (right != null)
            return new Result(root.val, right.max, 
                              Math.min(right.r, right.min - root.val));
        else
            return new Result(root.val, root.val, Integer.MAX_VALUE);
    }
}