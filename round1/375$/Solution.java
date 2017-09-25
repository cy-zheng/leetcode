/*
区间型dp
这道题的坑点在于，已知1~10的最优策略，猜不出10001~10010的最优策略，所以只能把两个区间分开计算
cache也要分开
这个题评分低也是有道理的

Discuss是一个top down的思路
For each number x in range[i~j]
we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
--> // the max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse branch.
then we get DP([i~j]) = min{xi, ... ,xj}
--> // this min makes sure that you are minimizing your cost.
*/

public class Solution {
    public int getMoneyAmount(int n) {
        int[][] table = new int[n + 1][n + 1];
        return DP(table, 1, n);
    }
    
    int DP(int[][] t, int s, int e){
        if(s >= e) return 0;
        if(t[s][e] != 0) return t[s][e];
        int res = Integer.MAX_VALUE;
        for(int x = s; x <= e; x++){  // 遍历所有可以猜的点
            int tmp = x + Math.max(DP(t, s, x - 1), DP(t, x + 1, e));  // 选择左右两个分支最大的花销
            res = Math.min(res, tmp);         // 选择一个总花销最小的点
        }
        t[s][e] = res;
        return res;
    }
}