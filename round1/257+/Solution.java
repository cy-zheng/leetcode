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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        List<List<Integer>> tmp = new ArrayList<>();
        dfs(root, new ArrayList<>(), tmp);
        for (List<Integer> l : tmp) {
            StringBuilder s = new StringBuilder(Integer.toString(l.get(0)));
            for (int i = 1; i < l.size(); i++) {
                s.append("->");
                s.append(Integer.toString(l.get(i)));
            }
            result.add(s.toString());
        }
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> path, List<List<Integer>> result) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(path);
            result.add(copy);
        }
        else {
            if (root.left != null)
                dfs(root.left, path, result);
            if (root.right != null)
                dfs(root.right, path, result);
        }
        path.remove(path.size() - 1);
    }
}