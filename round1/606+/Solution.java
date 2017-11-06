/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        String result = Integer.toString(t.val);
        if (t.left == null && t.right == null)
            return result;
        result += "(" + tree2str(t.left) + ")";
        if (t.right != null)
            result += "(" + tree2str(t.right) + ")";
        return result;
    }
}
