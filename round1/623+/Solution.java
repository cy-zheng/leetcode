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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode r = new TreeNode(v);
            r.left = root;
            return r;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            level++;
            if (level < d - 1) {                        // 还没到那一层，层序遍历
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    if (curr.left != null)
                        queue.add(curr.left);
                    if (curr.right != null)
                        queue.add(curr.right);
                }
            }
            else {                                       // 到了之后特殊处理
                List<TreeNode> list = new ArrayList<>();   // 父节点，queue里面是子节点
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    list.add(curr);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                for (TreeNode p : list) {
                    p.left = new TreeNode(v);
                    p.left.left = queue.poll();
                    p.right = new TreeNode(v);
                    p.right.right = queue.poll();
                }
                break;
            }
        }
        return root;
    }
}