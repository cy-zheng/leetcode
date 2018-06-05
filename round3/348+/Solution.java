/*
    计数的思想，计每行每列，两个对角线，双方旗子的个数，达到n后返回胜利
    int[] rows, cols;
    int diagonal, anti_diagonal, target;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        anti_diagonal = 0;
        target = n;
    }

    public int move(int row, int col, int player) {
        int sign = player == 1 ? 1 : -1, res = sign * target;
        rows[row] += sign;
        cols[col] += sign;
        if(row == col) diagonal += sign;
        if(row == target-1-col) anti_diagonal += sign;
        if(rows[row] == res || cols[col] == res || diagonal == res || anti_diagonal == res) return player;
        else return 0;
    }
*/

class TicTacToe {
    
    int[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (win(row, col, player))
            return player;
        return 0;
    }
    
    private boolean win(int row, int col, int player) {
        boolean win = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != player) {
                win = false;
                break;
            }
        }
        if (win)
            return win;
        
        win = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != player) {
                win = false;
                break;
            }
        }
        if (win)
            return win;
        
        win = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != player) {
                win = false;
                break;
            }
        }
        if (win)
            return win;
        
        win = true;
        for (int i = 0; i < board.length; i++) {
            if (board[board.length - i - 1][i] != player) {
                win = false;
                break;
            }
        }
        if (win)
            return win;
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
