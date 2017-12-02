class Solution {
    public int maxProfit(int[] prices, int fee) {
        int DP_ik0 = 0, DP_ik1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int ik0_old = DP_ik0;
            DP_ik0 = Math.max(DP_ik0, DP_ik1 + price);
            DP_ik1 = Math.max(DP_ik1, ik0_old - price - fee);
        }
        return DP_ik0;
    }
}
