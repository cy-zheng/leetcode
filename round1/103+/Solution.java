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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                tmp.add(curr.val);
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null) 
                    queue.add(curr.right);
            }
            if (!flag)
                Collections.reverse(tmp);
            flag = !flag;
            result.add(tmp);
        }
        return result;
    }
}