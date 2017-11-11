/*
    注意溢出
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
import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        List<Double> result = new ArrayList<>();
        while (queue.size() > 0) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            result.add(sum * 1.0 / size);
        }
        return result;
    }
}
