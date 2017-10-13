/*
    先reverse链表，然后就是标准的按位加法
    follow up要求的不允许改变链表结构，还没想好
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode result = new ListNode(0);
        boolean c = false;
        ListNode curr;
        while (l1 != null && l2 != null) {
            curr = new ListNode((l1.val + l2.val + (c ? 1 : 0)) % 10);
            c = l1.val + l2.val + (c ? 1 : 0) >= 10;
            curr.next = result.next;
            result.next = curr;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            curr = new ListNode((l1.val + (c ? 1 : 0)) % 10);
            c = l1.val + (c ? 1 : 0) >= 10;
            curr.next = result.next;
            result.next = curr;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            curr = new ListNode((l2.val + (c ? 1 : 0)) % 10);
            c = l2.val + (c ? 1 : 0) >= 10;
            curr.next = result.next;
            result.next = curr;
            l2 = l2.next;
        }
        
        if (c) {
            curr = new ListNode(1);
            curr.next = result.next;
            result.next = curr;
        }
        
        return result.next;
    }
    
    private ListNode reverse(ListNode l) {
        ListNode dummy = new ListNode(0);
        ListNode t1, t2;
        while (l != null) {
            t1 = l.next;
            t2 = dummy.next;
            dummy.next = l;
            l.next = t2;
            l = t1;
        }
        return dummy.next;
    }
}