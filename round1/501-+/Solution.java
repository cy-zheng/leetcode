/*
    follow up只使用栈空间完成这个题目还是有难度的
    思路是既然是BST，中序遍历有序，就使用中序遍历 + 前向双指针的思路
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
    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<>();
        int times = 1;
        
        int lastNum = Integer.MAX_VALUE;
        int lastIndex = -1;
        
        TreeNode curt = root;
        int index = 0;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            if (lastIndex == -1 || lastNum != curt.val) {
                if (lastIndex != -1 && index - lastIndex >= times) {
                    if (index - lastIndex > times) {
                        times = index - lastIndex;
                        result = new ArrayList<>();
                    }
                    result.add(lastNum);
                }
                lastNum = curt.val;
                lastIndex = index;
            }
            curt = curt.right;
            index++;
        }
        // 最后要多判断一次lastNum有没有超过times
        if (lastIndex != -1 && index - lastIndex >= times) {
            if (index - lastIndex > times) {
                times = index - lastIndex;
                result = new ArrayList<>();
            }
            result.add(lastNum);
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}