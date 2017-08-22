/*
    如何在修改值的同时又保证下一个点的计算不会被影响呢？实际上我们只要将值稍作编码就行了，因为题目给出的是一个int矩阵，大有空间可以利用。这里我们假设对于某个点，值的含义为:
    0 : 上一轮是0，这一轮过后还是0
    1 : 上一轮是1，这一轮过后还是1
    2 : 上一轮是0，这一轮过后变为1
    3 : 上一轮是1，这一轮过后变为0
    最后遍历一遍，做一次解码
*/

class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = judge(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3)
                    board[i][j] = 0;
                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    
    private int judge(int[][] copy, int i, int j) {
        int liveNum = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (!(x == 0 && y == 0) && test(copy, i + x, j + y)) {
                    if (copy[i + x][j + y] % 2 == 1) 
                        liveNum++;
                }
            }
        }
        if (copy[i][j] == 1) {
            if (liveNum == 2 || liveNum == 3)
                return 1;
            return 3;
        }
        else {
            if (liveNum == 3)
                return 2;
            return 0;
        }
        
    }
    
    private boolean test(int[][] copy, int i, int j) {
        if (i < 0 || i >= copy.length)
            return false;
        if (j < 0 || j >= copy[0].length)
            return false;
        return true;
    }
}