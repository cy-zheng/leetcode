import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] count = new int[m][n];
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        List<Point> buildings = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildings.add(new Point(i, j));
                }
            }
        }
        
        for (Point building : buildings) {
            Queue<Point> queue = new LinkedList<>();
            Set<String> set = new HashSet<>();
            int level = 0;
            queue.add(building);
            set.add(building.x + "#" + building.y);
            while (queue.size() > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Point p = queue.poll();
                    if (grid[p.x][p.y] == 0) {
                        count[p.x][p.y] += 1;
                        dist[p.x][p.y] += level;
                    }
                    for (int j = 0; j < 4; j++) {
                        int nx = p.x + dx[j];
                        int ny = p.y + dy[j];
                        if (test(grid, set, nx, ny)) {
                            set.add(nx + "#" + ny);
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
                level += 1;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0)
                    continue;
                if (count[i][j] != buildings.size())
                    continue;
                result = Math.min(result, dist[i][j]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private boolean test(int[][] grid, Set<String> set, int x, int y) {
        if (x < 0 || x >= grid.length)
            return false;
        if (y < 0 || y >= grid[0].length)
            return false;
        if (set.contains(x + "#" + y))
            return false;
        return grid[x][y] == 0;
    }
}
