/*
    leetcode 148
    链表的归并排序
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode tmp;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                tmp = l1.next;
                l1.next = null;
                cur.next = l1;
                l1 = tmp;
            }
            else {
                tmp = l2.next;
                l2.next = null;
                cur.next = l2;
                l2 = tmp;
            }
            cur = cur.next;
        }
        
        if (l1 != null)
            cur.next = l1;
        else if (l2 != null)
            cur.next = l2;
        
        return dummy.next;
    }
}
