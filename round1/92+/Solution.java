/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr = dummy, p = head, tmp1 = dummy2, tmp2 = null;
        int index = 0;
        while (p != null) {
            index++;
            if (index < m) {
                curr.next = p;
                p = p.next;
                curr = curr.next;
            }
            else if (index >= m && index <= n) {
                ListNode t = p.next;
                if (tmp1.next == null)
                    tmp2 = p;
                p.next = tmp1.next;
                tmp1.next = p;
                p = t;
                if (index == n) {
                    curr.next = dummy2.next;
                }
            }
            else{
                tmp2.next = p;
                p = p.next;
                tmp2 = tmp2.next;
            }
        }
        return dummy.next;
    }
}
