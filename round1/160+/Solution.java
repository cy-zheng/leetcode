/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int aLength = 0;
        int bLength = 0;
        
        ListNode curA = headA, curB = headB;
        while (curA != null){
            curA = curA.next;
            aLength++;
        }
        while (curB != null){
            curB = curB.next;
            bLength++;
        }
        curA = headA;
        curB = headB;
        if (aLength <= bLength) {
            int diff = bLength - aLength;
            while (diff != 0) {
                diff--;
                curB = curB.next;
            }
            while (curB != null){
                if (curA == curB) return curB;
                curA = curA.next;
                curB = curB.next;
            }
        }
        else {
            int diff = aLength - bLength;
            while (diff != 0) {
                diff--;
                curA = curA.next;
            }
            while (curB != null){
                if (curA == curB) return curB;
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
}