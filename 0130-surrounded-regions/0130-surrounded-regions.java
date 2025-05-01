
class Solution {
    List<Pair> mainList = new ArrayList<>();

    public char[][] solve(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    List<Pair> list = new ArrayList<>();
                    boolean[] isOnEdge = new boolean[]{false};
                    dfs(i, j, vis, board, list, isOnEdge);
                    if (!isOnEdge[0]) {
                        mainList.addAll(list);
                    }
                }
            }
        }

        for (Pair p : mainList) {
            int i = p.row;
            int j = p.col;
            board[i][j] = 'X';
        }

        return board;
    }

    public void dfs(int i, int j, boolean[][] vis, char[][] grid, List<Pair> list, boolean[] isOnEdge) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j] || grid[i][j] != 'O') {
            return;
        }

        vis[i][j] = true;

        // If it's on the border, mark isOnEdge
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            isOnEdge[0] = true;
        }

        list.add(new Pair(i, j));

        dfs(i + 1, j, vis, grid, list, isOnEdge); // down
        dfs(i - 1, j, vis, grid, list, isOnEdge); // up
        dfs(i, j + 1, vis, grid, list, isOnEdge); // right
        dfs(i, j - 1, vis, grid, list, isOnEdge); // left
    }
}

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
