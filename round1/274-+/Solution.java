/*
    二分答案
*/

import java.util.*;

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int min = 0;
        int max = citations[0];
        for (int c : citations)
            max = Math.max(c, max);
        
        while (min + 1 < max) {
            int mid = (max - min) / 2 + min;
            if (test(citations, mid))
                min = mid;
            else
                max = mid;
        }
        
        if (test(citations, max))
            return max;
        return min;
    }
    
    private boolean test(int[] nums, int bar) {
        int sum = 0;
        for (int n : nums) {
            if (n >= bar)
                sum++;
        }
        return sum >= bar;
    }
}