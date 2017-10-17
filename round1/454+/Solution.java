/*
    HashMap应用
*/

import java.util.*;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null)
            return 0;
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map1.put(A[i] + B[j], map1.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                map2.put(C[i] + D[j], map2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        
        int result = 0;
        for (int key : map1.keySet()) {
            if (map2.containsKey(0 - key)) 
                result += map1.get(key) * map2.get(0 - key);
        }
        return result;
    }
}