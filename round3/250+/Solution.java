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
    boolean isSame;
    int val;
    public Result(boolean isSame, int val) {
        this.isSame = isSame;
        this.val = val;
    }
}

public class Solution {
    
    int result;
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return result;
        dfs(root);
        return result;
    }
    
    private Result dfs(TreeNode root) {
        boolean isSame = true;
        if (root.left != null) {
            Result left = dfs(root.left);
            if (!left.isSame || left.val != root.val)
                isSame = false;
        }
        if (root.right != null) {
            Result right = dfs(root.right);
            if (!right.isSame || right.val != root.val)
                isSame = false;
        }
        
        if (isSame)
            result += 1;
        return new Result(isSame, root.val);
    }
}
