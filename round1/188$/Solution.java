/*
    http://blog.csdn.net/foreverling/article/details/43911309
*/

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (k >= prices.length) return infiniteProfit(prices);    // k过大，使用II的方法
        int[] g = new int[k + 1];
        int[] l = new int[k + 1];
        
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                l[j] = Math.max(g[j - 1] + Math.max(diff, 0), // i - 1天总共进行了j - 1次交易，最后一天买入一天卖出，可以选择不交易
                           l[j] + diff);      // i - 1天刚好进行j次交易，最后一天卖出，相当于延长一天卖出的时间，必须交易
                g[j] = Math.max(g[j],             // 全局最优 = max i - 1天的全局最优 i天卖出时的最优
                           l[j]);
            }
        }
        return g[k];
    }
    
    public int infiniteProfit(int[] prices) {
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