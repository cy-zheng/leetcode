/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode odd = new ListNode(1);
        ListNode even = new ListNode(1);
        ListNode oddCurr = odd;
        ListNode evenCurr = even;
        
        boolean flag = true;
        ListNode tmp;
        while (head != null) {
            tmp = head.next;
            if (flag) {
                oddCurr.next = head;
                head.next = null;
                oddCurr = oddCurr.next;
            }
            else {
                evenCurr.next = head;
                head.next = null;
                evenCurr = evenCurr.next;
            }
            flag = !flag;
            head = tmp;
        }
        oddCurr.next = even.next;
        return odd.next;
    }
}