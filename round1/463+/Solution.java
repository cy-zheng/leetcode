/*
    bfs解法
*/

import java.util.*;

class Solution {
    class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int x = 0, y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (queue.size() > 0) {
            Pair curr = queue.poll();
            result += findPerimeter(grid, curr.x, curr.y);
            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                if (test(grid, visited, nx, ny)) {
                    queue.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return result;
    }
    
    private boolean test(int[][] grid, boolean[][] visited, int nx, int ny) {
        if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
            if (!visited[nx][ny] && grid[nx][ny] == 1)
                return true;
        }
        return false;
    }
    
    private int findPerimeter(int[][] grid, int x, int y) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int result = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (!(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length)) {
                result += 1;
            }
            else if (grid[nx][ny] == 0)
                result += 1;
        }
        return result;
    }
}


/*
    Discuss解法，周长 = islands * 4 - neighbours * 2， 陆地面积 * 4 - 相邻边 * 2
    1. loop over the matrix and count the number of islands;
    2. if the current dot is an island, count if it has any right neighbour or down neighbour;
    3. the result is islands * 4 - neighbours * 2
*/

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}