class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && vis[i][j] == false) {
                    dfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, boolean[][] vis, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n || vis[i][j] || grid[i][j] == '0') {
            return;
        }

        vis[i][j] = true;

        dfs(i + 1, j, vis, grid); // down
        dfs(i - 1, j, vis, grid); // up
        dfs(i, j + 1, vis, grid); // right
        dfs(i, j - 1, vis, grid); // left
    }
}