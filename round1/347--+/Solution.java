/*
    比起HashMap+Heap的解法，散列解法更加好，总体时间复杂度O(n)
    因为频次小于n，建散列表，即新建大小为n+1的数组，数组下标为频次，数组内容为有相同频次的键值list，对散列表按下标由大到小遍历，找出k个键值
    注意两个元素可能有相同的次数
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