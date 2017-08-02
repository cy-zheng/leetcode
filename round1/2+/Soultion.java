/*
    常规题型，注意最后判断c一次
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        if (l1 == null && l2 == null) return dummy;
        
        ListNode cur = dummy;
        int c = 0;
        while (l1 != null && l2 != null){
            c += l1.val + l2.val;
            cur.next = new ListNode(c % 10);
            cur = cur.next;
            c /= 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null){
            c += l1.val;
            cur.next = new ListNode(c % 10);
            cur = cur.next;
            c /= 10;
            l1 = l1.next;
        }
        
        while (l2 != null){
            c += l2.val;
            cur.next = new ListNode(c % 10);
            cur = cur.next;
            c /= 10;
            l2 = l2.next;
        }
        
        if (c != 0){
            cur.next = new ListNode(c);
        }
        
        return dummy.next;
    }
}