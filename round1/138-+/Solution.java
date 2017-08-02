/*
    HashMap线程不安全，Hashtable线程安全，注意t是小写。
    31、33行需要判断null。
*/


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
import java.util.*;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        Map<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode p = head;
        
        while (p != null) {
            map.put(p.label, new RandomListNode(p.label));
            p = p.next;
        }
        
        p = head;
        while (p != null) {
            if (p.next != null)
                map.get(p.label).next = map.get(p.next.label);
            if (p.random != null)
                map.get(p.label).random = map.get(p.random.label);
            p = p.next;
        }
        
        return map.get(head.label);
    }
}