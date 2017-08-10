/*
    思路：http://blog.csdn.net/u012162613/article/details/41936569
    
    Suppose there are N elements and they range from A to B.
    最小值和最大值
    Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]
    最大的一个gap一定大于平均的diff
    Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / len + 1 of bucket
    一个桶之内的gap最大就是平均的diff，所以不会因为元素放在桶里就漏掉答案（重要！）
    for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len and therefore maintain the maximum and minimum elements in each bucket.
    每个桶维护最小值最大值
    Since the maximum difference between elements in the same buckets will be at most len - 1, so the final answer will not be taken from two elements in the same buckets.
    
    For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. Return the maximum of all those values.
    
    
    另外，java不能Array和Collection混用，比如：
    List<Integer>[] a;
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
        int prev = 0;  // 第一个桶和最后一个桶一定是有元素的，分别是min和max
        for (int i = 1; i < buckets.size(); i++) {  
            if (buckets.get(i) == null) continue;  
            gap = Math.max(gap, buckets.get(i).get(0) - buckets.get(prev).get(1));  
            prev = i;  
        }  
        return gap;  
    }
}