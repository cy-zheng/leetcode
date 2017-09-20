/*
    蓄水池抽样 - 流式数据等概率采样
    http://www.cnblogs.com/HappyAngel/archive/2011/02/07/1949762.html
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    
    private ListNode head;
    private Random random;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int result = -1, cnt = 0;
        ListNode curr = head;
        while (curr != null) {
            cnt++;
            if (random.nextInt(cnt) == 0)
                result = curr.val;
            curr = curr.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */