/*
    BST使用中序遍历是有序的
    非递归中序遍历思路：1、一直往左走，直到头；2、遍历当前节点，将右边节点放入栈
    注意记录走过的节点，不要重复走。
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class BSTIterator {
    
    private Stack<TreeNode> stack;
    private Set<TreeNode> set;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        set = new HashSet<>();
        if (root != null)
            stack.push(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        while (node != null && !set.contains(node)) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        set.add(node);
        if (node.right != null && !set.contains(node.right))
            stack.push(node.right);
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */