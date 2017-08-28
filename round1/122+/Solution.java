class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices == null || prices.length == 0) return result;
        int cur = prices[0];
        for (int p : prices) {
            if (cur < p)
                result += p - cur;
            cur = p;
        }
        return result;
    }
}