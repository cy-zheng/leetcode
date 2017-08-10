/*
    层序遍历，保存每层最后一个元素的值
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

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        int tail = 0, size;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode tmp;
        while(queue.size() > 0) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                tmp = queue.poll();
                tail = tmp.val;
                if (tmp.left != null) 
                    queue.offer(tmp.left);
                if (tmp.right != null)
                    queue.offer(tmp.right);
            }
            result.add(tail);
        }
        return result;
    }
}