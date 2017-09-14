/*
    排序+双指针
    HashMap可以做到O(n)
*/

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        int i = 0; 
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j])
                i++;
            while (i < nums1.length && j < nums2.length && nums1[i] > nums2[j])
                j++;
            if (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] list = new int[result.size()];
        for (int k = 0; k < result.size(); k++)
            list[k] = result.get(k);
        return list;
    }
}