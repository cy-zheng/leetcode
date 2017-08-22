/*
    经典单序列dp问题
*/

import java.util.*;

class Solution {
    public int numSquares(int n) {
        if (n == 1) return 1;
        List<Integer> squares = new ArrayList<>();
        int[] dp = new int[n + 1];
        squares.add(1);
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            if ((squares.size() + 1) * (squares.size() + 1) == i) {
                squares.add(i);
                dp[i] = 1;
            }
            else {
                int min = dp[i - 1] + 1;
                for (int s : squares) {
                    if (s < i) {
                        min = Math.min(dp[i - s] + 1, min);
                    }
                    else 
                        break;
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}