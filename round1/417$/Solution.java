/*
    此题只用BFS是不行的，BFS无法保存中间节点结果，需要多次扫描
*/

// DFS
import java.util.*;

class Solution {
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for(int i = 0; i < n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);  // 从边遍历到中心
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i = 0; i < m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (pacific[i][j] && atlantic[i][j]) 
                    res.add(new int[] {i, j});
        return res;
    }
    
    int[][]dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    
    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for (int[] d : dir){
            dfs(matrix, visited, matrix[x][y], x + d[0], y + d[1]);
        }
    }
}

// BFS
import java.util.*;

class Solution {
    
    class Pair {
        int i, j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;
        int[][] status = new int[matrix.length][matrix[0].length];  // 0: Nowhere 1: Pacific 2: Atlantic 3: Both
        boolean[][] visited;
        // init
        for (int i = 0; i < matrix.length; i++) {
            status[i][0] |= 1;
            status[i][matrix[0].length - 1] |= 2;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            status[0][j] |= 1;
            status[matrix.length - 1][j] |= 2;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<Pair> queue;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue = new LinkedList<>();
                queue.add(new Pair(i, j));
                visited = new boolean[matrix.length][matrix[0].length];
                visited[i][j] = true;
                while (queue.size() != 0) {
                    Pair curr = queue.poll();
                    status[i][j] |= status[curr.i][curr.j];
                    if (status[i][j] == 3) break;
                    for (int k = 0; k < 4; k++) {
                        if (test(matrix, curr.i, curr.j, curr.i + dx[k], curr.j + dy[k]) && !visited[curr.i + dx[k]][curr.j + dy[k]]) {
                            queue.add(new Pair(curr.i + dx[k], curr.j + dy[k]));
                            visited[curr.i + dx[k]][curr.j + dy[k]] = true;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (status[i][j] == 3) {
                    int[] tmp = new int[2];
                    tmp[0] = i;
                    tmp[1] = j;
                    result.add(tmp);
                }
            }
        }
        return result;
    }
    
    private boolean test(int[][] matrix, int i, int j, int ni, int nj) {
        if (ni < 0 || ni >= matrix.length)
            return false;
        if (nj < 0 || nj >= matrix[0].length)
            return false;
        return matrix[i][j] >= matrix[ni][nj];
    }
}