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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> r = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                r.add(curr.val);
                for (Node n : curr.children) {
                    queue.add(n);
                }
            }
            result.add(r);
        }
        return result;
    }
}
