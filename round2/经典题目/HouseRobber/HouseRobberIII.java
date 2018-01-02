/*
    leetcode 337
    在二叉树上，DFS解法
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
class Solution {
    
    class Pair {
        int r1, r2;
        public Pair(int r1, int r2) {
            this.r1 = r1;
            this.r2 = r2;
        }
    }
    
    public int rob(TreeNode root) {
        Pair result = dfs(root);
        return Math.max(result.r1, result.r2);
    }
    
    private Pair dfs(TreeNode root) {
        if (root == null)
            return new Pair(0, 0);
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        return new Pair(root.val + left.r2 + right.r2, Math.max(left.r1, left.r2) + Math.max(right.r1, right.r2));
    }
}
