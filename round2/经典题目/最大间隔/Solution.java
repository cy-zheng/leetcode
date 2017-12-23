/*
    leetcode 164
    分(max - min) / N + 1个桶，把N各元素分到(max - min) / len + 1个桶里面
    每个桶保存桶内的最小值和最大值
    这个做法之所以正确，因为桶内产生的差一定小于桶间产生的差
*/

import java.util.*;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        // 求最小值最大值
        int min = nums[0], max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        // 每个桶的长度len,向上取整所以加+1  
        int len = (max - min) / nums.length + 1;
        
        // 桶的个数:(maxNum - minNum) / len + 1,每个桶里面存储属于该桶的最大值和最小值即可，注意这里的最大最小值是局部的  
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < (max - min) / len + 1; i++) {
            buckets.add(null);
        }
        
        for (int x : nums) {  
            int i = (x - min) / len;  
            if (buckets.get(i) == null) {  
                buckets.set(i, new ArrayList<>());
                buckets.get(i).add(x);  
                buckets.get(i).add(x);  
            } else {  
                if (x < buckets.get(i).get(0)) buckets.get(i).set(0, x);  
                if (x > buckets.get(i).get(1)) buckets.get(i).set(1, x);  
            }  
        }
        
        // gap的计算，For each non-empty buckets p, find the next non-empty buckets q, return min（ q.min - p.max ）  
        int gap = 0;  
        int prev = 0;  
        for (int i = 1; i < buckets.size(); i++) {  
            if (buckets.get(i) == null) continue;  
            gap = Math.max(gap, buckets.get(i).get(0) - buckets.get(prev).get(1));  
            prev = i;  
        }  
        return gap;  
    }
}
