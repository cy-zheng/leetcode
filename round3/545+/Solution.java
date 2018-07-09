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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) 
            return result;
        result.add(root.val);
        if (root.left != null) {
            List<Integer> left = new ArrayList<>();
            getLeft(root, left);
            for (int i = 1; i < left.size() - 1; i++) {
                result.add(left.get(i));
            }
        }
        if (root.left != null || root.right != null) {
            List<Integer> leaves = new ArrayList<>();
            getLeaves(root, leaves);
            for (int i : leaves) {
                result.add(i);
            }
        }
        if (root.right != null) {
            List<Integer> right = new ArrayList<>();
            getRight(root, right);
            for (int i = right.size() - 2; i >= 1; i--) {
                result.add(right.get(i));
            }
        }
        
        return result;
    }
    
    private void getLeft(TreeNode root, List<Integer> list) {
        if (root == null) 
            return;
        list.add(root.val);
        if (root.left != null)
            getLeft(root.left, list);
        else if (root.right != null)
            getLeft(root.right, list);
    }
    
    private void getRight(TreeNode root, List<Integer> list) {
        if (root == null) 
            return;
        list.add(root.val);
        if (root.right != null)
            getRight(root.right, list);
        else if (root.left != null)
            getRight(root.left, list);
    }
    
    private void getLeaves(TreeNode root, List<Integer> list) {
        if (root == null) 
            return;
        if (root.left == null && root.right == null)
            list.add(root.val);
        else {
            if (root.left != null)
                getLeaves(root.left, list);
            if (root.right != null)
                getLeaves(root.right, list);
        }
    }
}
