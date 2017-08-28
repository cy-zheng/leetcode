class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minElement = prices[0];
        int result = 0;
        
        for (int p : prices) {
            result = Math.max(result, p - minElement);
            minElement = Math.min(minElement, p);
        }
        return result;
    }
}