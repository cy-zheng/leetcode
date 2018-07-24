import java.util.*;

class Point implements Comparable<Point> {
    int x, y, val;
    Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    public int compareTo(Point other) {
        return this.val - other.val;
    }
}

public class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        Set<String> set = new HashSet<>();
        PriorityQueue<Point> pq = new PriorityQueue<>();
        set.add("0,0");
        pq.add(new Point(0, 0, grid[0][0]));
        
        int res = 0;
        while (true) {
            while (pq.size() > 0 && pq.peek().val <= res) {
                Point curr = pq.poll();
                if (curr.x == N - 1 && curr.y == N - 1)
                    return res;
                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !set.contains(nx + "," + ny)) {
                        set.add(nx + "," + ny);
                        pq.add(new Point(nx, ny, grid[nx][ny]));
                    }
                }
            }
            res += 1;
        }
    }
}
