class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] dist = new int[seats.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        int result = 0;
        int d = Integer.MAX_VALUE;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1)
                d = 0;
            else {
                if (d != Integer.MAX_VALUE)
                    d += 1;
            }
            dist[i] = Math.min(dist[i], d);
        }
        d = Integer.MAX_VALUE;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1)
                d = 0;
            else {
                if (d != Integer.MAX_VALUE)
                    d += 1;
            }
            dist[i] = Math.min(dist[i], d);
            result = Math.max(result, dist[i]);
        }
        return result;
    }
}
