/*
    http://bookshadow.com/weblog/2015/11/24/leetcode-best-time-to-buy-and-sell-stock-with-cooldown/
*/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1] + diff);
            buy[i] = i > 1 ? Math.max(sell[i - 2] - prices[i], buy[i - 1] - diff) : buy[i - 1] - diff;
            result = Math.max(sell[i], result);
        }
        return result;
    }
}