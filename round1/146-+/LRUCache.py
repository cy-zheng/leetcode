/*
    这道题map存储节点的上一个时需要注意，修改删除当前链表元素时，
    要修改map中下一个节点所对应的元素。
*/

import java.util.*;

class ListNode {
    public int val;
    public int key;
    public ListNode next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {

    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new ListNode(0, 0);
        this.tail = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) return -1;
        ListNode preNode = this.map.get(key);
        ListNode curNode = preNode.next;
        if (this.tail != curNode){
            this.map.put(curNode.next.key, this.map.get(curNode.key));   // pay attention
            this.map.put(curNode.key, this.tail);                        // pay attention
            preNode.next = preNode.next.next;
            curNode.next = null;

            this.tail.next = curNode;
            this.tail = this.tail.next;
        }
        return curNode.val;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            get(key);
            this.tail.val = value;
        }
        else {
            if (this.size < this.capacity) {
                appendNode(key, value);
            }
            else {
                ListNode removeNode = this.head.next;
                this.map.remove(removeNode.key);
                this.head.next = this.head.next.next;
                this.size--;
                if (removeNode.next != null){                            // pay attention
                    this.map.put(removeNode.next.key, this.head);
                }
                if (removeNode == this.tail)
                    this.tail = this.head;
                appendNode(key, value);
            }
        }
    }

    private void appendNode(int key, int value) {
        this.map.put(key, this.tail);
        this.tail.next = new ListNode(key, value);
        this.tail = this.tail.next;
        this.size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */