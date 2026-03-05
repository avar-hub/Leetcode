class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(solve(i, j, word, board, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(int row, int col, String word, char[][] board, int wordPointer) {

        if(wordPointer == word.length())
            return true;

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return false;

        if(board[row][col] != word.charAt(wordPointer))
            return false;

        char temp = board[row][col];
        board[row][col] = '#';  
        boolean found =
                solve(row + 1, col, word, board, wordPointer + 1) ||
                solve(row - 1, col, word, board, wordPointer + 1) ||
                solve(row, col + 1, word, board, wordPointer + 1) ||
                solve(row, col - 1, word, board, wordPointer + 1);

        board[row][col] = temp; 
        return found;
    }
}