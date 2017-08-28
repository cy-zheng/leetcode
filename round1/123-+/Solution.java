/*
    dp1 从0开始到这一天的最大值
    dp2 从这一天到最后一天的最大值
*/

class Solution {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minElement = prices[0];
        int result = 0;
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, prices[i] - minElement);
            dp1[i] = result;
            minElement = Math.min(minElement, prices[i]);
        }
        result = 0;
        int maxElement = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            result = Math.max(result, maxElement - prices[i]);
            dp2[i] = result;
            maxElement = Math.max(maxElement, prices[i]);
        }
        
        result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, dp1[i] + dp2[i]);
        }
        return result;
    }
}