/*
    注意溢出
    ++index是先自增再引用
    index是先引用再自增
*/

import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0)
            return 0;
        if (heaters == null || heaters.length == 0)
            return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int result = Integer.MIN_VALUE;
        int[] pair = {(int) -(1e10), heaters[0]};
        int index = 0;
        
        for (int h : houses) {
            while (h >= pair[1]) {
                pair[0] = pair[1];
                if (index == heaters.length - 1)
                    pair[1] = (int) 1e10;
                else
                    pair[1] = heaters[++index];
            }
            result = Math.max(result, (int) Math.min(h + 0L - pair[0], pair[1] + 0L - h));
        }
        
        return result;
    }
}