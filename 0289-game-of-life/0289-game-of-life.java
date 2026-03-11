class Solution {
    public void gameOfLife(int[][] board) {
        int[][] ans = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && liveNeighbours(i, j, board) < 2) {
                    ans[i][j] = 0;
                } else if (board[i][j] == 1 && liveNeighbours(i, j, board) > 3) {
                    ans[i][j] = 0;
                } else if (board[i][j] == 0 && liveNeighbours(i, j, board) == 3) {
                    ans[i][j] = 1;
                } else if (board[i][j] == 1 && liveNeighbours(i, j, board) >= 2 && liveNeighbours(i, j, board) <= 3) {
                    ans[i][j] = 1;
                } else ans[i][j] = 0;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }

    private int liveNeighbours(int i, int j, int[][] board) {
        int count = 0;
        if (i > 0 && board[i - 1][j] == 1)
            count++;
        if (j > 0 && board[i][j - 1] == 1)
            count++;
        if (i < board.length - 1 && board[i + 1][j] == 1)
            count++;
        if (j < board[0].length - 1 && board[i][j + 1] == 1)
            count++;
        if (i > 0 && j < board[0].length - 1 && board[i - 1][j + 1] == 1)
            count++;
        if (j > 0 && i < board.length - 1 && board[i + 1][j - 1] == 1)
            count++;
        if (i < board.length - 1 && j < board[0].length - 1 && board[i + 1][j + 1] == 1)
            count++;
        if (j > 0 && i > 0 && board[i - 1][j - 1] == 1)
            count++;

        return count;
    }
}