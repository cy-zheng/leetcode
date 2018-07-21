/*
    The idea is simple by recursion.

    Just think about the current root, after processing, it will need to return [smaller/eq, larger] subtrees

    if root.val <=V, all nodes under root.left(including root) will be in the smaller/eq tree,
    we then split the root.right subtree into smaller/eq, larger, the root will need to concat the smaller/eq from the subproblem result (recursion).

    Similarly for the case root.val>V

    The runtime will be O(logn) if the input is balanced BST. Worst case is O(n) if it is not balanced.
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
class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root==null) return new TreeNode[]{null, null};
        
        TreeNode[] splitted;
        if(root.val<= V) {
            splitted = splitBST(root.right, V);
            root.right = splitted[0];
            splitted[0] = root;
        } else {
            splitted = splitBST(root.left, V);
            root.left = splitted[1];
            splitted[1] = root;
        }
        
        return splitted;
    }
}
