/*
    比较两个节点相等时，不能只比较val，要比较内存地址
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

class Result {
    boolean findP, findQ, findR;
    TreeNode LCA;
    Result(boolean findP, boolean findQ, boolean findR, TreeNode LCA){
        this.findP = findP;
        this.findQ = findQ;
        this.findR = findR;
        this.LCA = LCA;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result result = dfs(root, p, q);
        return result.LCA;
    }
    
    private Result dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return new Result(false, false, false, null);
        
        Result left = dfs(root.left, p, q);
        Result right = dfs(root.right, p, q);
        
        if (left.findR)
            return left;
        if (right.findR)
            return right;
        
        if ((left.findP || root == p) && (right.findQ || root == q))
            return new Result(true, true, true, root);
        
        if ((right.findP || root == p) && (left.findQ || root == q))
            return new Result(true, true, true, root);
        
        return new Result((left.findP || right.findP || root == p), 
                          (left.findQ || right.findQ || root == q), false, null);
    }
}