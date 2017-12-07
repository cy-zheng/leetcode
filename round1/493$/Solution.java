/*
* 本题非常难，参考http://www.cnblogs.com/grandyang/p/6657956.html
* 主要是使用树状数组求"小于等于给定值的元素出现的次数"
* 一开始我想要每个可能出现的int，都在树状数组中存在一个对应的位置
* 但是输入int范围太大，不可取
* 题目的思想是，对数组排序，树状数组不在int本身的位置存出现的次数，而是在该元素排序后的下标处存
* 这样子树状数组最大长度就是50001
*
* 使用一个map记录int到下标的映射关系
* */

import java.util.*;

class Solution {
    public int reversePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; i++) {
            if (!map.containsKey(sorted[i]))
                map.put(sorted[i], i + 1);
        }
        int result = 0;
        int[] bit = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            Integer lower = findLower(sorted, nums[i] / 2.0);
            if (lower != null)
                result += getSum(bit, map.get(lower));
            update(bit, map.get(nums[i]), 1);
        }
        return result;
    }

    private Integer findLower(int[] sorted, double v) {
        int left = 0, right = sorted.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (sorted[mid] >= v)
                right = mid;
            else
                left = mid;
        }
        if (sorted[right] < v)
            return sorted[right];
        if (sorted[left] < v)
            return sorted[left];
        return null;
    }

    private int getSum(int[] bit, int key) {
        int result = 0;
        while (key > 0) {
            result += bit[key];
            key -= key & -key;
        }
        return result;
    }

    private void update(int[] bit, int key, int diff) {
        while (key < bit.length) {
            bit[key] += diff;
            key += key &  -key;
        }
    }
}
