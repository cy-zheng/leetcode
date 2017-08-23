/*
    完美的证明：http://www.cnblogs.com/felixfang/p/3814463.html
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0)
            return -1;
        if (cost == null || cost.length == 0 || gas.length != cost.length)
            return -1;
        
        int result = 0;
        int acc = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (acc < 0) {
                acc = gas[i] - cost[i];
                result = i;
            }
            else
                acc += gas[i] - cost[i];
        }
        return total < 0 ? -1 : result;
    }
}