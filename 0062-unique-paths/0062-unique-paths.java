class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[101][101];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, m, n, dp);
    }

    public int helper(int stRow, int stCol, int m, int n, int[][] dp) {
        if (stRow == m - 1 && stCol == n - 1) {
            return 1;
        }
        if (stRow > m - 1 || stCol > n - 1) {
            return 0;
        }

        if (dp[stRow][stCol] != -1)
            return dp[stRow][stCol];

        int right = helper(stRow, stCol + 1, m, n, dp);
        int down = helper(stRow + 1, stCol, m, n, dp);

        dp[stRow][stCol] = right + down;

        return dp[stRow][stCol];

    }
}