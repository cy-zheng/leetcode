import java.util.*;

class Point {
    int x, y, step;
    String way;
    Point(int x, int y, int step, String way) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.way = way;
    }
}

public class Solution {
    public String findShortestWay(int[][] maze, int[] start, int[] hole) {
        Queue<Point> queue = new LinkedList<>();
        int[][] steps = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                steps[i][j] = Integer.MAX_VALUE;
            }
        }
        queue.add(new Point(start[0], start[1], 0, ""));
        steps[start[0]][start[1]] = 0;
        
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        
        int minStep = Integer.MAX_VALUE;
        String result = "";
        
        while (queue.size() > 0) {
            Point curr = queue.poll();
            if (curr.step >= minStep)
                continue;
            for (int i = 0; i < 4; i++) {
                int nx = curr.x, ny = curr.y, step = curr.step;
                String way = curr.way;
                if (isWall(maze, nx + dx[i], ny + dy[i]))
                    continue;
                switch (i) {
                    case 0:
                        way += "d";
                        break;
                    case 1:
                        way += "u";
                        break;
                    case 2:
                        way += "r";
                        break;
                    case 3:
                        way += "l";
                        break;
                }
                while (!isWall(maze, nx + dx[i], ny + dy[i])) {
                    nx += dx[i];
                    ny += dy[i];
                    step += 1;
                    if (nx == hole[0] && ny == hole[1] && step <= minStep) {
                        if (step < minStep) {
                            minStep = step;
                            result = way;
                        }
                        else if (result.compareTo(way) > 0)
                            result = way;
                    }
                }
                if (nx == hole[0] && ny == hole[1] && step <= minStep) {
                    if (step < minStep)
                        result = way;
                    else if (result.compareTo(way) > 0)
                        result = way;
                    System.out.println(minStep + " " + result);
                }
                if (step <= steps[nx][ny]) {
                    steps[nx][ny] = step;
                    queue.add(new Point(nx, ny, step, way));
                }
            }
        }
        System.out.println(minStep + " " + result);
        return result.length() == 0 ? "impossible" : result;
    }
    
    private boolean isWall(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length)
            return true;
        if (y < 0 || y >= maze[0].length)
            return true;
        return maze[x][y] == 1;
    }
}
