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

class Wrapper {
    TreeNode root;
    int index;
    Wrapper(TreeNode root, int index) {
        this.root = root;
        this.index = index;
    }
}

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<Wrapper> queue = new LinkedList<>();
        if (root != null) 
            queue.add(new Wrapper(root, 0));
        while (queue.size() > 0) {
            Wrapper w = queue.poll();
            if (!map.containsKey(w.index))
                map.put(w.index, new ArrayList<>());
            map.get(w.index).add(w.root.val);
            if (w.root.left != null)
                queue.add(new Wrapper(w.root.left, w.index - 1));
            if (w.root.right != null)
                queue.add(new Wrapper(w.root.right, w.index + 1));
        }
        for (int key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
