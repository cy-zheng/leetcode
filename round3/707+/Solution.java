class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    
    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node(-1);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
            if (curr == null)
                return -1;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node next = head.next;
        head.next = new Node(val);
        head.next.next = next;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
            if (curr == null)
                return;
        }
        
        Node next = curr.next;
        curr.next = new Node(val);
        curr.next.next = next;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
            if (curr == null)
                return;
        }
        
        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
