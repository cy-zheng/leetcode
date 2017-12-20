/*
    leetcode 141
    链表带环 -> 快慢指针不停走，相等代表有环
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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                if (slow.val == fast.val)
                    return true;
            }
            else
                return false;
        }
        return false;
    }
}
