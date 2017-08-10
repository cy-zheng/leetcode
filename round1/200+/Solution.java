class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int nx, ny;
        Pair tmp;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true;
                    while (queue.size() > 0) {
                        tmp = queue.poll();
                        for (int k = 0; k < 4; k++){
                            nx = tmp.x + dx[k];
                            ny = tmp.y + dy[k];
                            if (needVisit(grid, visited, nx, ny)) {
                                visited[nx][ny] = true;
                                queue.offer(new Pair(nx, ny));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    private boolean needVisit(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length) return false;
        if (j < 0 || j >= grid[0].length) return false;
        if (grid[i][j] == '0') return false;
        return !visited[i][j];
    }
}