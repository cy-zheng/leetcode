import java.util.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    
    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        Point[][] points = new Point[m][n];
        int curr = 0;
        for (int[] p : positions) {
            List<Point> merge = getNeighborhs(points, p[0], p[1]);
            curr += -(merge.size() - 1);
            result.add(curr);
            points[p[0]][p[1]] = new Point(p[0], p[1]);
            merge.add(points[p[0]][p[1]]);
            mergePoints(merge);
        }
        return result;
    }
    
    private List<Point> getNeighborhs(Point[][] points, int x, int y) {
        List<Point> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= points.length)
                continue;
            if (ny < 0 || ny >= points[0].length)
                continue;
            if (points[nx][ny] == null)
                continue;
            while (nx != points[nx][ny].x || ny != points[nx][ny].y) {
                Point father = points[points[nx][ny].x][points[nx][ny].y];
                points[nx][ny].x = father.x;
                points[nx][ny].y = father.y;
                nx = father.x;
                ny = father.y;
            }
            boolean add = true;
            for (Point p : result) {
                if (p.x == nx && p.y == ny) {
                    add = false;
                    break;
                }
            }
            if (add) 
                result.add(points[nx][ny]);
        }
        return result;
    }
    
    private void mergePoints(List<Point> points) {
        if (points.size() <= 1)
            return;
        Point father = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            points.get(i).x = father.x;
            points.get(i).y = father.y;
        }
    }
}

