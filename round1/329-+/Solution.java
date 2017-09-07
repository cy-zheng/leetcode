/*
    DFS + Cache
    由于题目性质，一个格子dfs，得出结果以后，可以缓存，不需要第二次dfs
*/

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;
        int[][] cache = new int[matrix.length][matrix[0].length];
        boolean[][] hasCache = new boolean[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!hasCache[i][j]) {
                    visited[i][j] = true;
                    cache[i][j] = dfs(matrix, i, j, visited, cache, hasCache);
                    visited[i][j] = false;
                    hasCache[i][j] = true;
                }
                result = Math.max(result, cache[i][j]);
            }
        }
        return result;
    }
    
    private int dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] cache, boolean[][] hasCache) {
        if (hasCache[i][j]) return cache[i][j];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int result = 1;
        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (test(x, y, visited)) {
                visited[x][y] = true;
                if (matrix[x][y] > matrix[i][j]) {
                    result = Math.max(result, dfs(matrix, x, y, visited, cache, hasCache) + 1);
                }
                visited[x][y] = false;
            }
        }
        hasCache[i][j] = true;
        cache[i][j] = result;
        return result;
    }
    
    private boolean test(int i, int j, boolean[][] visited) {
        if (i < 0 || i >= visited.length)
            return false;
        if (j < 0 || j >= visited[0].length)
            return false;
        return !visited[i][j];
    }
}