/*
    leetcode 384
    使用Knuth洗牌算法
    具体思想是：
    对数组从头到尾扫描一遍，扫描过程中，每次都从当前元素之前的元素中（包括当前元素，重要），随机选一个元素，跟当前扫描到的元素交换位置。
    参考：https://yjk94.wordpress.com/2017/03/17/%E6%B4%97%E7%89%8C%E7%9A%84%E6%AD%A3%E7%A1%AE%E5%A7%BF%E5%8A%BF-knuth-shuffle%E7%AE%97%E6%B3%95/
*/

import java.util.*;

class Solution {
    
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = (int[]) nums.clone();   // 注意clone方法
        for(int i = 1; i < nums.length; i++){
            int j = random.nextInt(i + 1);    // 此处要注意，这个元素可以和他本身交换
            swap(result, i, j);
        }
        return result;
    }
    
    private void swap(int[] list, int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
