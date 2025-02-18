class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] arr = new int[triangle.size()] [triangle.size()];
        int[][] dp = new int[triangle.size()] [triangle.size()];
        for(int[] row : arr) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int i = 0;
        for(List<Integer> list : triangle) {
            int n = list.size();
            for(int j = 0; j < n; j ++) {
                arr[i][j] = list.get(j);
            }
            i++;
        }

        return helper(arr, 0, 0, triangle.size() -1, dp);
    }

    private int helper(int[][] arr, int row, int col, int length, int[][] dp) {

        if(row > length|| col > length) {
            return Integer.MAX_VALUE;
        }

        if(row == length || col == length) {
            return arr[row][col];
        }

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        int down = helper(arr, row + 1, col, length, dp);
        int downRight = helper(arr, row + 1, col + 1, length, dp);

        dp[row][col] =  arr[row][col] + Math.min(down, downRight);
        return dp[row][col];
    }
}