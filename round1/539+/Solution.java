/*
    先排序，把时间围成一圈，单独处理一下首末两个的差
*/

import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) 
            result = Math.min(result, getDiff(timePoints.get(i), timePoints.get(i + 1), false));
        
        result = Math.min(result, getDiff(timePoints.get(timePoints.size() - 1), timePoints.get(0), true));
        return result;
    }
    
    public int getDiff(String s1, String s2, boolean flag) {
        int[] from = parseTime(s1);
        int[] to = parseTime(s2);
        if (flag)
            to[0] += 24;
        int result = 0;
        if (from[1] <= to[1]) {
            result += to[1] - from[1];
            result += (to[0] - from[0]) * 60;
        }
        else {
            result += 60 + to[1] - from[1];
            result += (to[0] - 1 - from[0]) * 60;
        }
        return result;
    }
    
    public int[] parseTime(String s) {
        String[] seg = s.split(":");
        int[] r = new int[2];
        r[0] = Integer.parseInt(seg[0]);
        r[1] = Integer.parseInt(seg[1]);
        return r;
    }
}