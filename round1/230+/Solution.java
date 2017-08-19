/*
    cnt：该节点之前还有多少个节点
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
    
    private int result = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k, 0);
        return result;
    }
    
    private int dfs(TreeNode root, int k, int cnt) {
        if (root == null)
            return cnt;
        
        int left = dfs(root.left, k, cnt);
        if (left + 1 == k)
            result = root.val;
        
        int right = dfs(root.right, k, left + 1);
        return right;
    }
}