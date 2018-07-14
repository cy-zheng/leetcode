/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        Node dummy = new Node(0, null, null, null);
        dfs(dummy, head);
        if (dummy.next != null)
            dummy.next.prev = null;
        return dummy.next;
    }
    
    private Node dfs(Node dummy, Node head) {
        if (head == null)
            return dummy;
        Node next = head.next;
        Node child = head.child;
        head.next = null;
        head.child = null;
        head.prev = dummy;
        dummy.next = head;
        dummy = dummy.next;
        dummy = dfs(dummy, child);
        return dfs(dummy, next);
    }
}
