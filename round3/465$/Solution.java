/*
    http://www.cnblogs.com/grandyang/p/6108158.html
*/

import java.util.*;

class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        // 先统计所有人最终账单情况
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
        }
        
        List<Integer> acc = new ArrayList<>();
        
        for (int key : map.keySet()) {
            // 剔除账单平衡的
            if (map.get(key) != 0)
                acc.add(map.get(key));
        }
        
        return dfs(acc, 0, 0);
    }
    
    // 可以理解为start指针左边的都是调整有序的
    private int dfs(List<Integer> acc, int start, int num) {
        // 确保start从一个需要调整的元素开始，在调整过程中，有可能后面的元素会被修改为0
        while (start < acc.size() && acc.get(start) == 0)
            start += 1;
        int result = Integer.MAX_VALUE;
        for (int i = start + 1; i < acc.size(); i++) {
            // 找到一对异号的
            if (acc.get(start) < 0 && acc.get(i) > 0 || acc.get(start) > 0 && acc.get(i) < 0) {
                // 把start都给i
                acc.set(i, acc.get(i) + acc.get(start));
                result = Math.min(result, dfs(acc, start + 1, num + 1));
                acc.set(i, acc.get(i) - acc.get(start));
            }
        }
        // result == Integer.MAX_VALUE 意味着没有找到与start异号的，说明都找完了
        return result == Integer.MAX_VALUE ? num : result;
    }
}
