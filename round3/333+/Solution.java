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
    int min, max, size;
    boolean valid;
    Result(int min, int max, int size, boolean valid) {
        this.min = min;
        this.max = max;
        this.size = size;
        this.valid = valid;
    }
}

public class Solution {
    
    int result = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private Result dfs(TreeNode root) {
        if (root == null) 
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        
        if (!left.valid || !right.valid) 
            return new Result(-1, -1, -1, false);
        
        if (left.max >= root.val || right.min <= root.val)
            return new Result(-1, -1, -1, false);
        
        Result ret = new Result(
            Math.min(root.val, left.min),
            Math.max(root.val, right.max),
            left.size + right.size + 1,
            true
        );
        result = Math.max(result, ret.size);
        return ret;
    }
}
