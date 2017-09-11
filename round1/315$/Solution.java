/*
    这道题如果没有重复元素的话，SortedSet也能做
    先把所有元素+偏移量，使最小元素等于1
    然后tree[i] = 元素i当前出现的次数
*/

import java.util.*;

class Solution {
    /*
    In this solution, we use a binary indexed tree (BIT)
    Our assumption is that all elements in nums are positive
    */

    static int MAX = 11000; //we set max value that can be store in the tree
    int[] tree = new int[MAX];

    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];

        //make all elements in the array posive while maintaining their order
        makePositive(nums);  // 加偏移量，最小值是1

        for(int i=nums.length-1; i>=0; i--){
            result[i] = get(nums[i] - 1);
            add(nums[i], 1);
        }
        return Arrays.asList(result);
    }

    public void makePositive(int[] nums){
        int min = MAX;
        for(int i=0; i<nums.length; i++)
            min = Math.min(min, nums[i]);
        if(min <= 0){
            min = -min+1;
            for(int i=0; i<nums.length; i++)
                nums[i] += min;
        }
    }

    public void add(int idx, int val){
        while(idx<MAX){
            tree[idx] += val;
            idx += (idx & (-idx)); // 应该包含这个val的后一个数
        }
    }

    public int get(int idx){ // 从第1个数到第idx个数的和
        int result = 0;
        while(idx>0){
            result += tree[idx];
            idx -= (idx & (-idx)); // tree[idx]覆盖范围之外的第一个数
        }
        return result;
    }
}