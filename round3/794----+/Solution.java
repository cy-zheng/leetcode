class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = count(board, 'X'), yCount = count(board, 'O');
        if (xCount < yCount || xCount - 1 > yCount)
            return false;
        if (line(board, 'X') && line(board, 'O'))
            return false;
        if (line(board, 'X') && xCount - 1 != yCount)
            return false;
        if (line(board, 'O') && xCount != yCount)
            return false;
        return true;
    }
    
    private int count(String[] board, char target) {
        int count = 0;
        for (String s : board) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == target)
                    count += 1;
            }
        }
        return count;
    }
    
    private boolean line(String[] board, char target) {
        for (String s : board) {
            boolean win = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != target) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }
        
        for (int i = 0; i < 3; i++) {
            boolean win = true;
            for (int j = 0; j < 3; j++) {
                if (board[j].charAt(i) != target) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }
        
        if (board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target)
            return true;
        if (board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) == target)
            return true;
        return false;
    }
}
