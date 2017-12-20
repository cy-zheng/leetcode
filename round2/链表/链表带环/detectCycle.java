/*
    leetcode 142
    先用快慢指针，找到两个指针相等的点
    然后一个指针从慢指针的位置，一个指针从head开始，一次走一格，相等时即为环开始的点
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
