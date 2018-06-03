import java.util.*;

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        
        Queue<Point> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new Point(i, j));
                    visited.add(i + "#" + j);
                }
            }
        }
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curr = queue.poll();
                rooms[curr.x][curr.y] = Math.min(rooms[curr.x][curr.y], level);
                for (int k = 0; k < 4; k++) {
                    int nx = curr.x + dx[k];
                    int ny = curr.y + dy[k];
                    if (test(rooms, visited, nx, ny)) {
                        queue.add(new Point(nx, ny));
                        visited.add(nx + "#" + ny);
                    }
                }
            }
            level += 1;
        }
    }
    
    private boolean test(int[][] rooms, Set<String> set, int x, int y) {
        if (x < 0 || x >= rooms.length)
            return false;
        if (y < 0 || y >= rooms[0].length)
            return false;
        if (set.contains(x + "#" + y))
            return false;
        return rooms[x][y] != -1;
    }
}
