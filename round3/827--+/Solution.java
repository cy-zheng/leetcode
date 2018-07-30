import java.util.*;

class Point {
    int x, y, size;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = 1;
    }
}

class UnionFind {
    Point[][] points;
    int maxSize = 0;
    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};
    
    public UnionFind(int[][] grid) {
        points = new Point[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxSize = Math.max(add(i, j), maxSize);
                }
            }
        }
    }
    
    private int add(int x, int y) {
        if (points[x][y] != null)
            return find(x, y).size;
        
        points[x][y] = new Point(x, y);
        List<Point> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < points.length && ny >= 0 
                && ny < points[0].length && points[nx][ny] != null) {
                neighbors.add(points[nx][ny]);
            }
        }
        if (neighbors.size() > 0) {
            neighbors.add(points[x][y]);
            for (int i = 1; i < neighbors.size(); i++) {
                merge(find(neighbors.get(0).x, neighbors.get(0).y), 
                      find(neighbors.get(i).x, neighbors.get(i).y));
            }
        }
        return find(x, y).size;
    }
    
    private void merge(Point source, Point target) {
        if (target.x == source.x && target.y == source.y)
            return;
        target.x = source.x;
        target.y = source.y;
        source.size += target.size;
    }
    
    public Point find(int x, int y) {
        Point curr = points[x][y];
        while (curr.x != x || curr.y != y) {
            x = curr.x;
            y = curr.y;
            curr.x = points[x][y].x;
            curr.y = points[x][y].y;
            curr = points[x][y];
        }
        return curr;
    }
}

public class Solution {
    
    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};
    
    public int largestIsland(int[][] grid) {
        UnionFind uf = new UnionFind(grid);
        int result = uf.maxSize;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<String> set = new HashSet<>();
                    int tmp = 1;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < grid.length && ny >= 0 
                            && ny < grid[0].length && grid[nx][ny] == 1) {
                            Point p = uf.find(nx, ny);
                            if (!set.contains(p.x + "," + p.y)) {
                                set.add(p.x + "," + p.y);
                                tmp += p.size;
                            }
                        }
                    }
                    result = Math.max(result, tmp);
                }
            }
        }
        return result;
    }
}
