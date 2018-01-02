/*
    leetcode 315
    BIT做法
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
        makePositive(nums);  // 加偏移量，最小值是0

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
            idx += (idx & (-idx));
        }
    }

    public int get(int idx){ // 从第一个数到第idx个数的和
        int result = 0;
        while(idx>0){
            result += tree[idx];
            idx -= (idx & (-idx));
        }
        return result;
    }
}
