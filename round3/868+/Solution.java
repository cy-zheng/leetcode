class Solution {
    public int binaryGap(int N) {
        int result = 0;
        int dist = Integer.MIN_VALUE;
        for (int i = 0; i < 32; i++) {
            boolean isOne = (N & (1 << i)) != 0;
            dist += 1;
            if (isOne) {
                result = Math.max(result, dist);
                dist = 0;
            }
        }
        return result;
    }
}
