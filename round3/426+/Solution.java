/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Result {
    Node start, end;
    Result(Node start, Node end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Result ret = convert(root);
        ret.start.left = ret.end;
        ret.end.right = ret.start;
        return ret.start;
    }
    
    private Result convert(Node root) {
        Result ret = new Result(root, root);
        Node left = root.left;
        Node right = root.right;
        root.left = null;
        root.right = null;
        if (left != null) {
            Result leftRet = convert(left);
            ret.start = leftRet.start;
            leftRet.end.right = root;
            root.left = leftRet.end;
        }
        if (right != null) {
            Result rightRet = convert(right);
            ret.end = rightRet.end;
            rightRet.start.left = root;
            root.right = rightRet.start;
        }
        return ret;
    }
}
