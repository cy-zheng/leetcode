/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    加父指针，BFS
*/

import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        generateParentsMap(root, map);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(target);
        set.add(target.val);
        for (int i = 0; i < K; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !set.contains(curr.left.val)) {
                    queue.add(curr.left);
                    set.add(curr.left.val);
                } 
                if (curr.right != null && !set.contains(curr.right.val)) {
                    queue.add(curr.right);
                    set.add(curr.right.val);
                }
                if (map.get(curr.val) != null && !set.contains(map.get(curr.val).val)) {
                    queue.add(map.get(curr.val));
                    set.add(map.get(curr.val).val);
                }
            }
        }
        while (queue.size() > 0) {
            result.add(queue.poll().val);
        }
        return result;
    }
    
    private void generateParentsMap(TreeNode root, Map<Integer, TreeNode> map) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left != null) {
            map.put(root.left.val, root);
            generateParentsMap(root.left, map);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            generateParentsMap(root.right, map);
        }
    }
}
