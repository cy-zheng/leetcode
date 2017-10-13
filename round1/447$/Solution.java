/*
    题意：
    将点组成一个三元组i，j，k，找i-j的距离等于j-k的距离的三元组个数。
    i、k互换算两个三元组
*/

import java.util.*;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i == j)
                    continue;

                int d = getDistance(points[i], points[j]);                
                map.put(d, map.getOrDefault(d, 0) + 1);  // 到这个点距离为d的点共有几个
            }

            for(int val : map.values()) {
                res += val * (val-1);       // 相当于全排列(A val 2)
            }            
            map.clear();
        }

        return res;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}