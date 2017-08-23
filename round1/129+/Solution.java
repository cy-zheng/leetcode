/*
    题意理解有误。
    本题相当于找所有到叶子节点的路径，然后把路径代表的数字加起来
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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        List<List<Character>> result = new ArrayList<>();
        List<Character> path = new ArrayList<Character>();
        path.add((char) (root.val + '0'));
        dfs(root, result, path);
        for (List<Character> l : result) {
            StringBuilder sb = new StringBuilder();
            for (Character c : l) {
                sb.append(c);
            }
            sum += Integer.parseInt(sb.toString());
        }
        return sum;
    }
    
    private void dfs(TreeNode root, List<List<Character>> result, List<Character> path) {
        if (root.left == null && root.right == null) {
            List<Character> tmp = new ArrayList<>();
            tmp.addAll(path);
            result.add(tmp);
            return;
        }
        
        if (root.left != null) {
            path.add((char) (root.left.val + '0'));
            dfs(root.left, result, path);
            path.remove(path.size() - 1);
        }
        
        if (root.right != null) {
            path.add((char) (root.right.val + '0'));
            dfs(root.right, result, path);
            path.remove(path.size() - 1);
        }
    }
}