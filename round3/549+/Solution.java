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
    int up, down, val;
    Result(int up, int down, int val) {
        this.up = up;
        this.down = down;
        this.val = val;
    }
}

public class Solution {
    
    int result = 0;
    
    public int longestConsecutive(TreeNode root) {
        find(root);
        return result;
    }
    
    private Result find(TreeNode root) {
        if (root == null) {
            return new Result(0, 0, 0);
        }
        Result left = find(root.left);
        Result right = find(root.right);
        int leftUp = 0, leftDown = 0, rightUp = 0, rightDown = 0;
        if (left.val - 1 == root.val)
            leftDown = left.down;
        if (left.val + 1 == root.val)
            leftUp = left.up;
        if (right.val - 1 == root.val)
            rightDown = right.down;
        if (right.val + 1 == root.val)
            rightUp = right.up;
        
        result = Math.max(result, Math.max(leftUp + rightDown, leftDown + rightUp) + 1);
        
        Result ret = new Result(0, 0, root.val);
        if (left.val - 1 == root.val)
            ret.down = Math.max(ret.down, left.down + 1);
        if (right.val - 1 == root.val)
            ret.down = Math.max(ret.down, right.down + 1);
        if (left.val + 1 == root.val)
            ret.up = Math.max(ret.up, left.up + 1);
        if (right.val + 1 == root.val)
            ret.up = Math.max(ret.up, right.up + 1);
        
        if (ret.up == 0)
            ret.up = 1;
        if (ret.down == 0)
            ret.down = 1;
        return ret;
    }
}
