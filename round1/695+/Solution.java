import java.util.*;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == 0)
                    continue;
                int count = 0;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] {i, j});
                visited[i][j] = true;
                while (queue.size() > 0) {
                    int[] curr = queue.poll();
                    count++;
                    for (int k = 0; k < 4; k++) {
                        int nx = curr[0] + dx[k];
                        int ny = curr[1] + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length 
                           && !visited[nx][ny] && grid[nx][ny] == 1) {
                            visited[nx][ny] = true;
                            queue.add(new int[] {nx, ny});
                        }
                    }
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
