/*
    题目要求尽可能压缩，所以只序列化前序遍历结果，中序遍历可以由前序遍历排序得到
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }
    
    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        if (sb.length() == 0) {
            sb.append(Integer.toString(root.val));
        }
        else {
            sb.append(",");
            sb.append(Integer.toString(root.val));
        }
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] values = data.split(",");
        int[] preorder = new int[values.length];
        int[] inorder = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            preorder[i] = Integer.parseInt(values[i]);
            inorder[i] = Integer.parseInt(values[i]);
        }
        Arrays.sort(inorder);
        
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd)
            return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int mid = -1;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == preorder[pStart]) {
                mid = i;
                break;
            }
        }
        root.left = buildTree(preorder, pStart + 1, pStart + mid - iStart, inorder, iStart, mid - 1);
        root.right = buildTree(preorder, pStart + mid - iStart + 1, pEnd, inorder, mid + 1, iEnd);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));