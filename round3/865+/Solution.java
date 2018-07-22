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
    
    private int maxDepth = 0;
    private int count = 0;
    private TreeNode result = null;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        find(root, 0);
        return result;
    }
    
    private int find(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        int left = find(root.left, depth + 1);
        int right = find(root.right, depth + 1);
        int curr = left + right + (depth == maxDepth ? 1 : 0);
        if (curr == count && result == null)
            result = root;
        return curr;
    }
    
    private void dfs(TreeNode root, int depth) {
        if (root == null) 
            return;
        if (depth == maxDepth)
            count += 1;
        if (depth > maxDepth) {
            count = 1;
            maxDepth = depth;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
