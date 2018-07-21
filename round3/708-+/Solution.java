/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node result = new Node(insertVal);
            result.next = result;
            return result;
        }
        if (head.next == head) {
            head.next = new Node(insertVal);
            head.next.next = head;
            return head;
        }
        
        Node big = head;
        while (big.next.val >= big.val && big.next != head) {
            big = big.next;
        }
        
        Node curr = big;
        int i = 0;
        while (curr.next.val < insertVal && (i == 0 || curr != big)) {
            curr = curr.next;
            i += 1;
        }
        Node next = curr.next;
        curr.next = new Node(insertVal);
        curr.next.next = next;
        return head;
    }
}
