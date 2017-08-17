/*
    本道题找的是目标元素的上一个小的元素，和下一个大的元素，需要使用TreeSet保持有序。
    SortedSet.headSet不包含当前查找的元素
    SortedSet.tailSet包含当前查找的元素
    
    但是SortedSet提供的接口慢，TLE
    直接用TreeSet的接口才能过
*/

import java.util.*;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        Long head, tail;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove((long)nums[i - k - 1]);
            }
            
            head = set.floor((long)nums[i]);
            if (head != null && (long)nums[i] - head <= t) {
                return true;
            }
                
            tail = set.ceiling((long)nums[i]);
            if (tail != null && tail - nums[i] <= t){
                return true;
            }
            set.add((long)nums[i]);   
        }
        return false;
    }
}