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
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        
        int result = 0;
        boolean inGraph = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!inGraph) {
                    inGraph = true;
                    result += 1;
                }
            }
            else {
                inGraph = false;
            }
            head = head.next;
        }
        return result;
    }
}
