class Solution {
    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int live = liveNeighbours(i, j, board);

                if (board[i][j] == 1 && live < 2) {
                    board[i][j] = -1;
                } 
                else if (board[i][j] == 1 && live > 3) {
                    board[i][j] = -1;
                } 
                else if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }

        // convert encoded values to final state
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == -1)
                    board[i][j] = 0;

                if (board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }

    private int liveNeighbours(int i, int j, int[][] board) {

        int count = 0;

        if (i > 0 && Math.abs(board[i - 1][j]) == 1) count++;
        if (j > 0 && Math.abs(board[i][j - 1]) == 1) count++;
        if (i < board.length - 1 && Math.abs(board[i + 1][j]) == 1) count++;
        if (j < board[0].length - 1 && Math.abs(board[i][j + 1]) == 1) count++;

        if (i > 0 && j < board[0].length - 1 && Math.abs(board[i - 1][j + 1]) == 1) count++;
        if (j > 0 && i < board.length - 1 && Math.abs(board[i + 1][j - 1]) == 1) count++;
        if (i < board.length - 1 && j < board[0].length - 1 && Math.abs(board[i + 1][j + 1]) == 1) count++;
        if (j > 0 && i > 0 && Math.abs(board[i - 1][j - 1]) == 1) count++;

        return count;
    }
}