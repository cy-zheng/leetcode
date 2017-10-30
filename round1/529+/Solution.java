import java.util.*;

class Solution {
    
    private int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    private int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};
    
    class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {        
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        else {
            if (countMines(board, click[0], click[1]) == 0) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                visited[click[0]][click[1]] = true;
                Queue<Pair> queue = new LinkedList<>();
                queue.add(new Pair(click[0], click[1]));
                while (queue.size() > 0) {
                    Pair curr = queue.poll();
                    int count = countMines(board, curr.x, curr.y);
                    board[curr.x][curr.y] = count == 0 ? 'B' : (char) (count + '0');
                    if (count == 0) {
                        for (int i = 0; i < 8; i++) {
                            if (test(visited, curr.x + dx[i], curr.y + dy[i])) {
                                queue.add(new Pair(curr.x + dx[i], curr.y + dy[i]));
                                visited[curr.x + dx[i]][curr.y + dy[i]] = true;
                            }
                        }
                    }
                }
            }
            else {
                board[click[0]][click[1]] = (char) (countMines(board, click[0], click[1]) + '0');
            }
            return board;
        }
    }
    
    private boolean test(boolean[][] visited, int x, int y) {
        if (x < 0 || x >= visited.length)
            return false;
        if (y < 0 || y >= visited[0].length)
            return false;
        return !visited[x][y];
    }
    
    private int countMines(char[][] board, int x, int y) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= board.length)
                continue;
            if (ny < 0 || ny >= board[0].length)
                continue;
            if (board[nx][ny] == 'M')
                result += 1;
        }
        return result;
    }
}