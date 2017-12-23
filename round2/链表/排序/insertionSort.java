/*
    leetcode 147
    创建一个ordered链表，每次插入到这个链表的对应位置
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
    public ListNode insertionSortList(ListNode head) {
        ListNode ordered = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = null;
            insert(ordered, curr);
            curr = next;
        }
        return ordered.next;
    }

    private void insert(ListNode ordered, ListNode curr) {
        while (ordered.next != null) {
            if (ordered.next.val > curr.val) {
                ListNode next = ordered.next;
                ordered.next = curr;
                curr.next = next;
                return;
            }
            ordered = ordered.next;
        }
        ordered.next = curr;
    }
}
