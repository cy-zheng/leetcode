/*
    单序列型dp
*/

import java.util.*;

class Solution {
    
    class Pair implements Comparable<Pair> {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int compareTo(Pair other) {
            if (this.end != other.end)
                return this.end - other.end;
            return this.start - other.start;
        }
    }
    
    public int findLongestChain(int[][] pairs) {
        Pair[] ps = new Pair[pairs.length];
        for (int i = 0; i < pairs.length; i++)
            ps[i] = new Pair(pairs[i][0], pairs[i][1]);
        
        Arrays.sort(ps);
        
        int[] dp = new int[pairs.length];
        int result = 0;
        
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (ps[j].end < ps[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}