/*
    leetcode 146
    注意由于是双向链表，删除一个节点时，这个节点，pre，next都要跟着变化
*/

import java.util.*;

class LRUCache {

    class Node {
        int key, val;
        Node pre, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity, size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = head;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node currNode = map.get(key);
        if (currNode != tail) {
            currNode.pre.next = currNode.next;
            if (currNode.next != null)
                currNode.next.pre = currNode.pre;
            currNode.next = null;
            currNode.pre = tail;
            tail.next = currNode;
            tail = tail.next;
        }
        return currNode.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            get(key);
            map.get(key).val = value;
        }
        else {
            if (size < capacity) {
                size++;
                Node currNode = new Node(key, value);
                map.put(key, currNode);
                tail.next = currNode;
                currNode.pre = tail;
                tail = tail.next;
            }
            else {
                Node removeNode = head.next;
                head.next = head.next.next;
                if (head.next != null)
                    head.next.pre = head;
                size--;
                map.remove(removeNode.key);
                put(key, value);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
