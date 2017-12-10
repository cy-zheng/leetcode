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
    整体的思路是，先从大往小扫描，找出第一个逆序的，其中小的是一个错误
    然后从小往大扫描，找到第一个逆序的，其中大的是错误的
    最后交换
*/

class Solution {
    
    private int cache;
    private boolean hasFind;
    
    public void recoverTree(TreeNode root) {
        // find the smaller miss one
        cache = Integer.MAX_VALUE;
        hasFind = false;
        scanRight(root);
        int p1 = cache;
        // find the bigger miss one
        cache = Integer.MIN_VALUE;
        hasFind = false;
        scanLeft(root);
        int p2 = cache;
        // swap them
        swap(root, p1, p2);
    }
    
    private void scanRight(TreeNode root) {
        if (root == null || hasFind)
            return;
        scanRight(root.right);
        if (!hasFind) {  // 注意这里还需要多判断一次，因为如果之前的递归修改了hasFind，这里不进行判断，会覆盖之前的结果
            if (root.val > cache)
                hasFind = true;
            else
                cache = root.val;
        }
        scanRight(root.left);
    }

    private void scanLeft(TreeNode root) {
        if (root == null || hasFind)
            return;
        scanLeft(root.left);
        if (!hasFind) {  // 注意这里还需要多判断一次，因为如果之前的递归修改了hasFind，这里不进行判断，会覆盖之前的结果
            if (root.val < cache)
                hasFind = true;
            else
                cache = root.val;
        }
        scanLeft(root.right);
    }
    
    private void swap(TreeNode root, int p1, int p2) {
        if (root == null)
            return;
        swap(root.left, p1, p2);
        if (root.val == p1)
            root.val = p2;
        else if (root.val == p2)
            root.val = p1;
        swap(root.right, p1, p2);
    }
    
}
