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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start == end) 
            return new TreeNode(nums[start]);
        else {
            int mid = (start + end) / 2;
            TreeNode result = new TreeNode(nums[mid]);
            if (mid - 1 >= start)
                result.left = helper(nums, start, mid - 1);
            if (mid + 1 <= end)
                result.right = helper(nums, mid + 1, end);
            return result;
        }
    } 
}