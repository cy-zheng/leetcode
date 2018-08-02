public class Solution {

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    // 判断当前砖块是不是stable。
    // 1、周围有砖块是stable的
    // 2、x == 0 [Important]
    private boolean stable(int[][] grid, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length
                    && grid[nx][ny] == 2)
                return true;
        }
        return x == 0;
    }
    
    // 把所有砖块标成stable，并且统计个数
    private int dfs(int[][] grid, int x, int y) {
        int result = 1;
        grid[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length
                    && grid[nx][ny] == 1)
                result += dfs(grid, nx, ny);
        }
        return result;
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int M = grid.length, N = grid[0].length;
        int[] result = new int[hits.length];
        for (int i = 0; i < hits.length; i++) {
            grid[hits[i][0]][hits[i][1]] -= 1;
        }
        for (int i = 0; i < N; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
        }
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            // 这里需要注意，即使当前打掉的砖块不是stable的，但是仍然置为1.
            // 因为打掉之前的砖块时，可能会影响到它
            grid[x][y] += 1;
            if (grid[x][y] == 1) {
                if (stable(grid, x, y))
                    result[i] = dfs(grid, x, y) - 1;
            }
        }
        return result;
    }
}
