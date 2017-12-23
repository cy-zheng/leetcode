/*
    leetcode 169
    Moore voting algorithm--每找出两个不同的element，就成对删除即count--，最终剩下的一定就是所求的。时间复杂度：O(n)
*/

public class Solution {
    public int majorityElement(int[] nums) {
        int elem = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                elem = nums[i];
            if (elem == nums[i])
                count++;
            else
                count--;
        }
        
        return elem;
    }
}
