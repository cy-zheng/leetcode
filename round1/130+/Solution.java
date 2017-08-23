import java.util.*;

class Solution {
    
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) 
            return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                visited[i][0] = true;
                queue.add(new Pair(i, 0));
            }
            if (board[i][board[0].length - 1] == 'O' && !visited[i][board[0].length - 1]) {
                visited[i][board[0].length - 1] = true;
                queue.add(new Pair(i, board[0].length - 1));
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                visited[0][j] = true;
                queue.add(new Pair(0, j));
            }
            if (board[board.length - 1][j] == 'O' && !visited[board.length - 1][j]) {
                visited[board.length - 1][j] = true;
                queue.add(new Pair(board.length - 1, j));
            }
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (queue.size() > 0) {
            Pair p = queue.poll();
            for (int k = 0; k < 4; k++) {
                if (test(board, visited, p.x + dx[k], p.y + dy[k])) {
                    visited[p.x + dx[k]][p.y + dy[k]] = true;
                    queue.offer(new Pair(p.x + dx[k], p.y + dy[k]));
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }
    
    private boolean test(char[][] board, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= board.length)
            return false;
        if (y < 0 || y >= board[0].length)
            return false;
        return board[x][y] == 'O' && !visited[x][y];
    }
}