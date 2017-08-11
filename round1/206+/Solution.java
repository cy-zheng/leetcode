/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode result = null, tmp;
        while (head != null) {
            tmp = head.next;
            head.next = result;
            result = head;
            head = tmp;
        }
        return result;
    }
}