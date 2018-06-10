import java.util.*;

class Point {
    int x, y, step;
    Point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<Point> queue = new LinkedList<>();
        int[][] steps = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                steps[i][j] = Integer.MAX_VALUE;
            }
        }
        queue.add(new Point(start[0], start[1], 0));
        steps[start[0]][start[1]] = 0;
        
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        
        int result = Integer.MAX_VALUE;
        
        while (queue.size() > 0) {
            Point curr = queue.poll();
            if (curr.x == destination[0] && curr.y == destination[1]) {
                result = Math.min(result, curr.step);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = curr.x, ny = curr.y, step = curr.step;
                while (!isWall(maze, nx + dx[i], ny + dy[i])) {
                    nx += dx[i];
                    ny += dy[i];
                    step += 1;
                }
                if (step < steps[nx][ny]) {
                    steps[nx][ny] = step;
                    queue.add(new Point(nx, ny, step));
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private boolean isWall(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length)
            return true;
        if (y < 0 || y >= maze[0].length)
            return true;
        return maze[x][y] == 1;
    }
}
