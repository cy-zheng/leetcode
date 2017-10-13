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
    
    private int result;
    
    public int pathSum(TreeNode root, int sum) {
        result = 0;
        for (int tmp : dfs(root, sum)) {
            if (tmp == sum)
                result++;
        }
        return result;
    }
    
    private List<Integer> dfs(TreeNode root, int sum) {
        if (root == null) 
            return new ArrayList<Integer>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(root.val);
        for (int i : dfs(root.left, sum)) {
            if (i == sum)
                result++;
            tmp.add(root.val + i);
        }
        for (int i : dfs(root.right, sum)) {
            if (i == sum)
                result++;
            tmp.add(root.val + i);
        }
        return tmp;
    }
}