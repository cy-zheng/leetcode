class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int outTime = -1;
        for (int t : timeSeries) {
            if (t + duration <= outTime)
                continue;
            else {
                if (t >= outTime)
                    result += duration;
                else 
                    result += duration - (outTime - t);
                outTime = t + duration;
            }
        }
        return result;
    }
}