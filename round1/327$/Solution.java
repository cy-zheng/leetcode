/*
    http://blog.csdn.net/miss_snow_m/article/details/50520885
*/

import java.util.*;

class Solution {
    
    class FenwickTree {  // 树状数组实现
        int n;  
        int[] c;  
  
        FenwickTree(int n) {  // n个数
            this.n = n;  
            c = new int[n + 1];  
        }  
  
        public int lowbit(int x) {  
            return x & -x;  
        }  
  
        public void insert(int x, int dif) { // 注意n是从1开始，dif是新旧的差 
            while (x <= n) {  
                c[x] += dif;  
                x += lowbit(x);  
            }  
        }  
  
        public int sum(int x) {  // 注意x是从1开始，计算第一个到第x个元素的和
            int ans = 0;  
            while (x > 0) {  
                ans += c[x];  
                x -= lowbit(x);  
            }  
            return ans;  
        }  
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;  
        long sums[] = new long[n]; // 前缀和数组 
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();  
        for (int i = 0; i < n; i++) {  
            if (i == 0)  
                sums[i] = nums[i];  
            else  
                sums[i] = sums[i - 1] + nums[i];  
            map.put(sums[i], 0);  
        }  
        map.put(Long.MAX_VALUE, 0);  
        map.put(Long.MIN_VALUE, 0);  
  
        int tot = 1;  
        for (Iterator<Long> ite = map.keySet().iterator(); ite.hasNext();) {  // 此处保证key是按照由小到大的顺序
            long key = ite.next();
            map.put(key, tot++);  
        }  
  
        FenwickTree tree = new FenwickTree(n + 2);  
        int ans = 0;  
        long right, left;  
        for (int i = 0; i < n; i++) {  
            long s = sums[i];  
            left = map.ceilingKey(s - upper);  // 比s - upper大的最小的key
            right = map.floorKey(s - lower);  // 比s - upper小的最大key
            ans += tree.sum(map.get(right)) - tree.sum(map.get(left) - 1);  
            if (lower <= s && s <= upper)  
                ans++;  
            tree.insert(map.get(s), 1);  
        }  
  
        return ans;  
    }
}