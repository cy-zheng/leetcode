/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
import java.util.*;

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    
    private void dfs(Node root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        for (Node n : root.children) {
            dfs(n, result);
        }
    }
}
