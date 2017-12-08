/*
    并查集基本题目
    对于每个n，检查n + 1，n - 1是否有元素相邻，有元素就连接
    并且要在并查集中计数
*/

import java.util.*;

class Solution {
    
    class Item {
        int size, parent;
        public Item(int size, int parent) {
            this.size = size;
            this.parent = parent;
        }
    }
    
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        Map<Integer, Item> map = new HashMap<>();
        int result = 1;
        for (int n : nums) {
            if (!map.containsKey(n))
                map.put(n, new Item(1, n));
            if (n > Integer.MIN_VALUE && map.containsKey(n - 1) && find(map, n) != find(map, n - 1)) {
                connect(map, n, n - 1);
                result = Math.max(result, getSize(map, n));
            }
            if (n < Integer.MAX_VALUE && map.containsKey(n + 1) && find(map, n) != find(map, n + 1)) {
                connect(map, n, n + 1);
                result = Math.max(result, getSize(map, n));
            }
        }
        
        return result;
    }
    
    public int find(Map<Integer, Item> map, int n) {
        while (map.get(n).parent != n) {
            map.get(n).parent = map.get(map.get(n).parent).parent;
            n = map.get(n).parent;
        }
        return n;
    }
    
    public void connect(Map<Integer, Item> map, int m, int n) {
        int p1 = find(map, m);
        int p2 = find(map, n);
        if (p1 != p2) {
            map.get(p1).parent = p2;
            map.get(p2).size += map.get(p1).size;
        }
    }
    
    public int getSize(Map<Integer, Item> map, int n) {
        int p = find(map, n);
        return map.get(p).size;
    }
}
