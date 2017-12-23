/*
    leetcode 229
    这道题和Majority Element I都是摩尔投票法 Moore Voting
    在每一轮投票过程中，从数组中找出一对不同的元素，将其从数组中删除。这样不断的删除直到无法再进行投票，如果数组为空，则没有任何元素出现的次数超过该数组长度的一半。如果只存在一种元素，那么这个元素则可能为目标元素。
    
    任意一个数组出现次数大于n/3的众数最多有两个，我们使用投票法的核心是找出两个候选众数进行投票，需要两遍遍历，第一遍历找出两个候选众数，第二遍遍历重新投票验证这两个候选众数是否为众数即可
*/

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int m = 0, n = 0, cm = 0, cn = 0;
        for (Integer a : nums) {
            if (a == m) cm++;
            else if (a ==n) cn++;
            else if (cm == 0) {
                m = a;
                cm = 1;
            }
            else if (cn == 0) {
                n = a;
                cn = 1;
            } 
            else {
                cm--;
                cn--;
            }
        }
        
        cm = cn = 0;
        for (Integer a : nums) {
            if (a == m)
                cm++;
            else if (a == n)
                cn++;
        }
        if (cm > nums.length / 3)
            result.add(m);
        if (cn > nums.length / 3)
            result.add(n);
        
        return result;
    }
}
