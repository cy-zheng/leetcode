public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        if (points == null) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slope = new HashMap<>();
            int maxPoints = 0, overlap = 0, vertical = 0;

            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        overlap++;
                    } else {
                        vertical++;
                    }
                    continue;
                }
                int dx = points[i].x - points[j].x;
                int dy = points[i].y - points[j].y;
                int tmp = gcd(dx, dy);
                dx /= tmp;
                dy /= tmp;
                String k = dy + "/" + dx;

                if (!slope.containsKey(k)) {
                    slope.put(k, 0);
                }
                slope.put(k, slope.get(k) + 1);
                maxPoints = Math.max(maxPoints, slope.get(k));
            }
            maxPoints = Math.max(maxPoints, vertical);
            ans = Math.max(ans, maxPoints + overlap + 1);
        }
        return ans;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}