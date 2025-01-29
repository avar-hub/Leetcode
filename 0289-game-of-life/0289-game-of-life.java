class Solution {
    public void gameOfLife(int[][] board) {
        int[][] newStage = new int[board.length][board[0].length];
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0},  {-1, -1}, {1, 1},  {-1, 1}, {1, -1}  };        
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cell = board[i][j];
                if (cell == 0) {
                    if(checkReproduction(i, j, board, directions)) {
                        newStage[i][j] = 1;
                    } else {
                        newStage[i][j] = 0;
                    }
                } else {
                    if(checkUnderPopulation(i, j, board, directions)) {
                        newStage[i][j] = 0;
                    } else if(checkOverPopulation(i, j, board, directions)) {
                        newStage[i][j] = 0;
                    } else {
                        newStage[i][j] = 1;
                    }
                }
            }
        }
    for(int i = 0; i < board.length ; i++) {
        for( int j = 0; j < board[0].length; j++) {
            board[i][j] = newStage[i][j];
        }
    }
    }

    private boolean checkReproduction(int i , int j, int[][] board, int[][] direction) {
        int liveCellCount = 0;
       for ( int[] dir : direction) {
        int newRow = i + dir[0];
        int newCol = j + dir[1];
        if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
            if(board[newRow][newCol] == 1) {
                liveCellCount++;
            }
        }
       }

       if(liveCellCount == 3) {
        return true;
       } 
       return false;

    }

    private boolean checkUnderPopulation(int i , int j , int[][] board,  int[][] direction) {
        int liveCellCount = 0;
       for ( int[] dir : direction) {
        int newRow = i + dir[0];
        int newCol = j + dir[1];
        if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
            if(board[newRow][newCol] == 1) {
                liveCellCount++;
            }
        }
       }

       if(liveCellCount < 2) {
        return true;
       } 
       return false;
    }

    private boolean checkOverPopulation(int i , int j , int[][] board,  int[][] direction) {
        int liveCellCount = 0;
       for ( int[] dir : direction) {
        int newRow = i + dir[0];
        int newCol = j + dir[1];
        if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
            if(board[newRow][newCol] == 1) {
                liveCellCount++;
            }
        }
       }
       if(liveCellCount > 3) {
        return true;
       } 
       return false;
    }

}