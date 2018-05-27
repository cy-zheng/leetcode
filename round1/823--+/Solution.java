/*
    %MOD 还需要继续熟练
*/

import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        int[] count = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        int MOD = (int) (1e9 + 7);
        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
            map.put(A[i], i);
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (map.containsKey(A[i] / A[j])) {
                    int other = A[i] / A[j];
                    if (A[j] * other != A[i])
                        continue;
                    if (A[j] == other) {
                        count[i] += (int) ((count[j] * 1L * count[j]) % MOD);
                    }
                    else {
                        count[i] += (int) ((count[j] * 1L * count[map.get(other)]) % MOD);
                    }
                    count[i] %= MOD;
                }
            }
        }
        int sum = 0;
        for (int i : count) {
            sum += i % MOD;
            sum %= MOD;
        }
        return sum;
    }
}
