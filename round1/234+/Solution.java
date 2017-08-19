/*
    两个链表基本操作，翻转和找中点
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        
        ListNode slow = head, fast = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) break;
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        right = reverse(right);
        
        while (right != null) {
            if (right.val != left.val)
                return false;
            right = right.next;
            left = left.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0), t1, t2;
        while (head != null) {
            t1 = dummy.next;
            t2 = head.next;
            dummy.next = head;
            head.next = t1;
            head = t2;
        }
        return dummy.next;
    }
}