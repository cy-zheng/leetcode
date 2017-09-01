/*
    这个递归的唯一难点在于：如何能够在每次递归调用中，用O(1)时间内获得链表中部的节点？这也是此题和Convert Array to BST的最大不同之处。

    在一般情况下，这点本来是做不到的，但是在这里我们可以通过递归“累积”的方式来实现。设想，我们维护一个全局变量h，最初指向左半链表的头。我们每处理一个左链表的节点，h就向后移动一位。这样，当我们处理完左半链表时，h正好处于左半链表尾的下一个元素，这个元素恰好是整个树的root，所以我们才使用h.val来初始化root。之所以递归必须是中序，是因为h只有在左半链表都处理完毕后才能获得。
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private ListNode h;
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = 0;
        h = head;
        ListNode tmp = head;
        while(tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return myBuild(0, len - 1);
    }
    
    public TreeNode myBuild(int low,int high) {
        if(low > high) return null;
        int mid = (low + high) / 2;
        TreeNode left = myBuild(low, mid - 1);
        TreeNode root = new TreeNode(h.val);
        root.left = left;
        h = h.next;
        TreeNode right = myBuild(mid + 1, high);
        root.right = right;
        return root;
    }
    
}