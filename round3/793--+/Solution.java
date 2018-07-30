class Solution {
    public int preimageSizeFZF(long K) {
        long left = 0, right = Long.MAX_VALUE;
        long minIndex = -1, maxIndex = -1;
        while (left + 1 < right) {
            long mid = (right - left) / 2 + left;
            if (f(mid) >= K)
                right = mid;
            else
                left = mid;
        }
        if (f(left) == K)
            minIndex = left;
        else if (f(right) == K)
            minIndex = right;
        
        left = 0;
        right = Long.MAX_VALUE;
        while (left + 1 < right) {
            long mid = (right - left) / 2 + left;
            if (f(mid) <= K)
                left = mid;
            else
                right = mid;
        }
        if (f(right) == K)
            maxIndex = right;
        else if (f(left) == K)
            maxIndex = left;
        
        if (minIndex == -1 || maxIndex == -1 || minIndex > maxIndex)
            return 0;
        return (int) (maxIndex - minIndex + 1);
    }
    
    public long f(long x) {
        if (x == 0)
            return 0;
        long cnt = 0;
        for (long i = 5; i <= x && i > 0; i *= 5)
            cnt += x / i;
        return cnt;
    }
}

// 1000000000
