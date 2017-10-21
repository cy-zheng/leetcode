/*
    小坑很多，见注释
*/

import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>(11, new Comparator<Integer>() {        // 这里不能简单的加负号改为大根堆
            public int compare(Integer i1, Integer i2) {                                        // Integer.MIN_VALUE加负号会溢出
                if (i1 < i2)
                    return 1;
                if (i1 == i2)
                    return 0;
                return -1;
            }
        });
        PriorityQueue<Integer> max = new PriorityQueue<>(11);
        double[] result = new double[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min.size() == 0 || min.peek() >= nums[i]) {
                min.add(nums[i]);
            }
            else {
                max.add(nums[i]);
            }
            rebalance(min, max);

            if (i >= k) {
                if (!min.remove(nums[i - k]))          // 这里必须判断第一次删除的结果，否则有可能删除两次
                    max.remove(nums[i - k]);
                rebalance(min, max);
            }

            if (i >= k - 1)
                result[index++] = getResult(min, max);
        }
        return result;
    }

    private void rebalance(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        if (min.size() > max.size() + 1)
            max.add(min.poll());
        else if (min.size() < max.size())
            min.add(max.poll());
    }

    private double getResult(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        if ((min.size() + max.size()) % 2 == 1)
            return min.peek();
        else
            return min.peek() / 2.0 + max.peek() / 2.0;               // 这里不能先相加再除以2，有可能溢出
    }
}