/*
    leetcode 121
    只能交易一次，随时记录最低值
*/

class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int result = 0;
        for (int p : prices) {
            result = Math.max(result, p - lowest);
            lowest = Math.min(lowest, p);
        }
        return result;
    }
}

/*
    leetcode 122
    可以无限次交易，只要当前比上一个有上升，就加上
*/

class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int result = 0;
        for (int p : prices) {
            if (p > lowest)
                result += p - lowest;
            lowest = p;
        }
        return result;
    }
}

/*
    leetcode 123
    限制最多进行两次交易，于是找这两次交易的分界点
*/

class Solution {
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minElement = prices[0];
        int result = 0;
        int[] dp1 = new int[prices.length];   // dp1[i]：从0开始到第i天的最大收入
        int[] dp2 = new int[prices.length];   // dp2[i]：从第i天开始到最后一天的最大收入
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
        // 最后答案为，第i天为分界线的最大收入
        result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, dp1[i] + dp2[i]);
        }
        return result;
    }
}
