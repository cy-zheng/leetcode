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
    
    class Wrapper {
        int val, length;
        public Wrapper(int val, int length) {
            this.val = val;
            this.length = length;
        }
    }
    
    int result = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private Wrapper dfs(TreeNode root) {
        if (root == null)
            return new Wrapper(0, -1);
        Wrapper left = dfs(root.left);
        Wrapper right = dfs(root.right);
        if (root.val == left.val && root.val == right.val) {
            result = Math.max(result, left.length + right.length + 2);
            return new Wrapper(root.val, 1 + Math.max(left.length, right.length));
        }
        else if (root.val == left.val) {
            result = Math.max(result, 1 + left.length);
            return new Wrapper(root.val, 1 + left.length);
        }
        else if (root.val == right.val) {
            result = Math.max(result, 1 + right.length);
            return new Wrapper(root.val, 1 + right.length);
        }
        else {
            return new Wrapper(root.val, 0);
        }
    }
}
