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

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            // 从栈里取出元素访问
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);  //先右边再左边
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}