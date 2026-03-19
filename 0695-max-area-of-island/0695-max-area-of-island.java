class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, solve(i, j , grid));
                }
            }
        }
        return max;
    }

    private int solve(int i , int j , int[][] grid) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;

    grid[i][j] = 0;

    int count = 1;

    count += solve(i + 1, j, grid);
    count += solve(i - 1, j, grid);
    count += solve(i, j + 1, grid);
    count += solve(i, j - 1, grid);

    return count;
    }
}