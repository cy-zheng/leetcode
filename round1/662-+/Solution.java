/*
      用了一个性质，父节点的左孩子下标2 * i，右孩子下标2 * i + 1，其中i为父节点下标
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
    
    class Item {
        int index;
        TreeNode node;
        public Item(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int r = 1;
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(0, root));
        while (queue.size() > 0) {
            int size = queue.size();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Item curr = queue.poll();
                min = Math.min(min, curr.index);
                max = Math.max(max, curr.index);
                if (curr.node.left != null)
                    queue.add(new Item(2 * curr.index, curr.node.left));
                if (curr.node.right != null)
                    queue.add(new Item(2 * curr.index + 1, curr.node.right));
            }
            if (max >= min)
                r = Math.max(r, max - min + 1);
        }
        return r;
    }
}
