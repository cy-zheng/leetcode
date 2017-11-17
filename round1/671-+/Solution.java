/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return min2 == Integer.MAX_VALUE ? -1 : min2;
    }
    
    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        dfs(root.right);
        if (root.val < min1) {
            min2 = min1;
            min1 = root.val;
        }
        else if (root.val > min1 && root.val < min2)
            min2 = root.val;
    }
}