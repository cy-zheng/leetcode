/*
    leetcode 347
    类似于桶排序的思想，把count分到各个桶中
    然后从大到小，把桶中的元素加到result
*/

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<List<Integer>> hp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            hp.add(new ArrayList<>());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!count.containsKey(nums[i])) 
                count.put(nums[i], 0);
            count.put(nums[i], count.get(nums[i]) + 1);
        }
        
        for (int key : count.keySet())
            hp.get(count.get(key) - 1).add(key);
        int i = hp.size() - 1;
        while (result.size() < k) {
            while (hp.get(i).size() == 0)
                i--;
            result.addAll(hp.get(i));
            i--;
        }
        return result;
    }
}
