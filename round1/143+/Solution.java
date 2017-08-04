/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // get length of the list
        ListNode p = head;
        int length = 0;
        while (p != null){
            p = p.next;
            length++;
        }
        // cut the list
        ListNode l1 = head;
        ListNode l2 = head;
        for (int i = 0; i < (length + 1) / 2 - 1; i++) {
            l2 = l2.next;
        }
        ListNode tmp = l2.next;
        l2.next = null;
        l2 = tmp;
        l2 = reverseList(l2);
        // merge
        ListNode tmp1, tmp2;
        while (l2 != null) {
            tmp1 = l1.next;
            tmp2 = l2.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        head.next = null;
        ListNode tmp;
        while (p != null) {
            tmp = p.next;
            p.next = head;
            head = p;
            p = tmp;
        }
        return head;
    }
}