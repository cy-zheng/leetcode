/*
   序列化的结果类似"1,null,2,3,4,null,null,null,null"
   相当于树的最下面都是null
   使用bfs进行序列化和反序列化
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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        sb.append(Integer.toString(root.val));
        sb.append(",");
        while (queue.size() > 0) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                sb.append("null,");
            }
            else {
                sb.append(Integer.toString(cur.left.val));
                sb.append(",");
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                sb.append("null,");
            }
            else {
                sb.append(Integer.toString(cur.right.val));
                sb.append(",");
                queue.offer(cur.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] strings = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode cur = queue.poll();
                if (!strings[i].equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(strings[i]));
                    queue.add(cur.left);
                }
                i++;
                if (!strings[i].equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(strings[i]));
                    queue.add(cur.right);
                }
                i++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));