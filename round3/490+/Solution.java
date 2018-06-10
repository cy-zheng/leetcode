import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<Point> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(new Point(start[0], start[1]));
        set.add(start[0] + "#" + start[1]);
        
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        
        while (queue.size() > 0) {
            Point curr = queue.poll();
            if (curr.x == destination[0] && curr.y == destination[1])
                return true;
            for (int i = 0; i < 4; i++) {
                int nx = curr.x, ny = curr.y;
                while (!isWall(maze, nx + dx[i], ny + dy[i])) {
                    nx += dx[i];
                    ny += dy[i];
                }
                if (!set.contains(nx + "#" + ny)) {
                    set.add(nx + "#" + ny);
                    queue.add(new Point(nx, ny));
                }
            }
        }
        return false;
    }
    
    private boolean isWall(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length)
            return true;
        if (y < 0 || y >= maze[0].length)
            return true;
        return maze[x][y] == 1;
    }
}
