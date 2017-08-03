/*
    不能假设两个Node的value一样即是同一个节点，要比较对象地址。
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                if (slow == fast) {
                    ListNode p = head;
                    while (p != slow) {
                        p = p.next;
                        slow = slow.next;
                    }
                    return p;
                }
            }
            else
                return null;
        }
        return null;
    }
}