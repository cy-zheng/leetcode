/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (helper(head)) {
            ListNode root = new ListNode(1);
            root.next = head;
            return root;
        }
        return head;
    }
    
    private boolean helper(ListNode root) {
        if (root == null)
            return true;
        boolean result = helper(root.next);
        if (result) {
            root.val += 1;
            if (root.val >= 10) {
                root.val = 0;
                return true;
            }
        }
        return false;
    }
}
