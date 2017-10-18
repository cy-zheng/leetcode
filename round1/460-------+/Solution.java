/*
    思路请参考：http://www.jianshu.com/p/437f53341f67
    总的来说，双向链表的修改要注意三点：
    1、当前节点内部指针修改
    2、前后节点指向当前节点的指针
    3、某些全局（外部）的指针
*/

import java.util.*;

class LFUCache {

    class Node {         // 实际装载元素的Node
        int key, value;
        Node before, next;
        FreqNode outer;                // 指向fNode
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class FreqNode {        // 装载相同freq节点的Node
        int freq;
        Node head, tail;        // tail位是最旧的Node
        FreqNode before, next;
        public FreqNode(int freq) {
            this.freq = freq;
            head = new Node(-1, -1);
            tail = head;
        }
    }

    private int size, capacity;
    private Map<Integer, Node> map;
    private FreqNode tail;              // tail是freq最小的Node

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
    }

    // 删除一个节点，如果节点删除后父节点为空，那么删除父节点
    private void removeNode(Node curr) {
        Node before = curr.before;
        Node next = curr.next;
        before.next = next;
        if (next != null)
            next.before = before;
        if (curr.outer.tail == curr)
            curr.outer.tail = before;
        removeFreqNode(curr.outer);
    }

    // 在FreqNode下添加一个Node
    private void addNode(FreqNode fNode, Node node) {
        node.outer = fNode;
        Node before = fNode.head;
        Node next = fNode.head.next;
        if (fNode.tail == fNode.head)
            fNode.tail = node;
        node.before = before;
        node.next = next;
        before.next = node;
        if (next != null)
            next.before = node;
    }

    // 删除一个fNode
    private void removeFreqNode(FreqNode fNode) {
        if (fNode.head != fNode.tail)
            return;
        if (tail == fNode)
            tail = fNode.next;

        FreqNode before, next;
        before = fNode.before;
        next = fNode.next;
        if (before != null)
            before.next = next;
        if (next != null)
            next.before = before;
    }

    public int get(int key) {
        if (capacity == 0)
            return -1;
        if (!map.containsKey(key))
            return -1;
        Node curr = map.get(key);
        if (curr.outer.next == null) {
            curr.outer.next = new FreqNode(curr.outer.freq + 1);
            curr.outer.next.before = curr.outer;
        }
        if (curr.outer.next.freq != curr.outer.freq + 1) { // 下一个节点，不一定刚好freq = 当前freq + 1
            FreqNode next = curr.outer.next;
            curr.outer.next = new FreqNode(curr.outer.freq + 1);
            next.before = curr.outer.next;
            curr.outer.next.next = next;
            curr.outer.next.before = curr.outer;
        }
        removeNode(curr);
        addNode(curr.outer.next, curr);
        return curr.value;
    }

    public void testTail() {
        if (tail == null) {
            tail = new FreqNode(0);
        }
        else if (tail.freq != 0) {
            FreqNode next = tail;
            tail = new FreqNode(0);
            tail.next = next;
            tail.next.before = tail;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (map.containsKey(key)) {        // 在map中含有key时，再次set，freq不清零，而是等于原有值 + 1
            Node curr = map.get(key);
            curr.value = value;
            if (curr.outer.next == null) {
                curr.outer.next = new FreqNode(curr.outer.freq + 1);
                curr.outer.next.before = curr.outer;
            }
            if (curr.outer.next.freq != curr.outer.freq + 1) {
                FreqNode next = curr.outer.next;
                curr.outer.next = new FreqNode(curr.outer.freq + 1);
                next.before = curr.outer.next;
                curr.outer.next.next = next;
                curr.outer.next.before = curr.outer;
            }
            removeNode(curr);
            addNode(curr.outer.next, curr);
        }
        else {
            if (size < capacity) {
                Node curr = new Node(key, value);
                testTail();
                addNode(tail, curr);
                map.put(key, curr);
                size++;
            }
            else {
                Node last = tail.tail;
                removeNode(last);
                map.remove(last.key);
                Node curr = new Node(key, value);
                testTail();
                addNode(tail, curr);
                map.put(key, curr);
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */