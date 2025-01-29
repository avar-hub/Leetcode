class Solution {
    public void gameOfLife(int[][] board) {
        int[][] newStage = new int[board.length][board[0].length];
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0},  {-1, -1}, {1, 1},  {-1, 1}, {1, -1}  };        
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cell = board[i][j];
                int lives = checkLive(i, j, board, directions);
                if (cell == 0) {
                    if(lives == 3) {
                        newStage[i][j] = 1;
                    } else {
                        newStage[i][j] = 0;
                    }
                } else {
                    if(lives < 2) {
                        newStage[i][j] = 0;
                    } else if(lives > 3) {
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

    private int checkLive(int i , int j, int[][] board, int[][] direction) {
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
       return liveCellCount;
    }

}