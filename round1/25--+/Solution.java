/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    快慢指针找需要反转的子序列，然后翻转，递归调用自己
*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;
        return reverseK(head, k);
    }
    
    private ListNode reverseK(ListNode head, int k) {
        ListNode slow = head, fast = head;
        int count = 1;
        while (count != k && fast != null) {
            count++;
            fast = fast.next;
        }
        if (fast == null)
            return head;
        ListNode next = fast.next;
        fast.next = null;
        reverseAll(slow);
        slow.next = reverseK(next, k);
        return fast;
    }
    
    private void reverseAll(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
    }
}
