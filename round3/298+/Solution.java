/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Result {
    int val, length;
    public Result(int val, int length) {
        this.val = val;
        this.length = length;
    }
}

public class Solution {
    
    int result = 0;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return result;
        dfs(root);
        return result;
    }
    
    private Result dfs(TreeNode root) {
        Result left, right;
        Result r = new Result(root.val, 1);
        if (root.left != null) {
            left = dfs(root.left);
            if (left.val == root.val + 1)
                r.length = Math.max(r.length, 1 + left.length);
        }
        if (root.right != null) {
            right = dfs(root.right);
            if (right.val == root.val + 1)
                r.length = Math.max(r.length, 1 + right.length);
        }
        result = Math.max(result, r.length);
        return r;
    }
}
