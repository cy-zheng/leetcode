/*
    leetcode 1
    输入数组无序，需要返回原来的下标
    所以使用Pair类包装一下
*/

import java.util.Arrays;

class Pair implements Comparable<Pair>{
    public int value;
    public int index;
    public Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
    public int compareTo(Pair other){
        return this.value - other.value;
    } 
}

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++){
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        int i = 0;
        int j = pairs.length - 1;
        int[] result = new int[2];
        while (i < j) {
            if (pairs[i].value + pairs[j].value == target) {
                result[0] = pairs[i].index;
                result[1] = pairs[j].index;
                return result;
            }
            else if (pairs[i].value + pairs[j].value < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return result;
    }
}
