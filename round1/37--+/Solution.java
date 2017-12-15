/*
    dfs经典题目，使用三个数组保存每行、每列、每个小矩阵出现的数字，避免使用HashSet
    对于每个未知量进行一次递归
*/

class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] mat = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int curr = board[i][j] - '1';
                    row[i][curr] = true;
                    col[j][curr] = true;
                    mat[3 * (i / 3) + j / 3][curr] = true;
                }
            }
        }

        dfs(board, row, col, mat, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] mat, int x, int y) {
        for (int i = x; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    continue;

                for (int val = 0; val < 9; val++) {
                    if (row[i][val] || col[j][val] || mat[3 * (i / 3) + j / 3][val])
                        continue;
                    board[i][j] = (char) ('1' + val);
                    row[i][val] = true;
                    col[j][val] = true;
                    mat[3 * (i / 3) + j / 3][val] = true;
                    if (dfs(board, row, col, mat, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1))
                        return true;
                    board[i][j] = '.';
                    row[i][val] = false;
                    col[j][val] = false;
                    mat[3 * (i / 3) + j / 3][val] = false;
                }
                return false;
            }
        }
        return true;
    }
}
