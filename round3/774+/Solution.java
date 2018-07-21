class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < stations.length; i++) {
            max = Math.max(max, stations[i] - stations[i - 1]);
        }
        
        double left = 0, right = max;
        while (left + 0.0000001 < right) {
            double mid = (right - left) / 2 + left;
            if (test(stations, K, mid)) {
                right = mid;
            }
            else
                left = mid;
        }
        return left;
    }
    
    private boolean test(int[] stations, int K, double mid) {
        for (int i = 1; i < stations.length; i++) {
            if (stations[i] - stations[i - 1] > mid) {
                // 需要增加的station = 间隔数 - 1
                // 间隔数 = 该间隔 / mid （上取整）
                int inc = (int) Math.ceil((stations[i] - stations[i - 1]) * 1.0 / mid) - 1;
                if (inc > K)
                    return false;
                K -= inc;
            }
        }
        return true;
    }
}
