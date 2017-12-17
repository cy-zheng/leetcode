/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
    leetcode 206
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp1 = dummy.next, tmp2;
            dummy.next = curr;
            tmp2 = curr.next;
            curr.next = tmp1;
            curr = tmp2;
        }
        return dummy.next;
    }
}
