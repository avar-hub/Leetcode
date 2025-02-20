class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[5001][2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(prices, 0, 0, 0, dp);
    }

    private int solve(int[] prices, int index, int buy, int max, int[][] dp) {

        if(index >= prices.length) {
            return 0;
        }

        if(dp[index][buy] != -1) {
            return dp[index][buy];
        }

        if(buy == 0) {

            int take = solve(prices, index+1, 1, max, dp) - prices[index];

            int notTake = solve(prices, index + 1, 0, max, dp);

            int n = Math.max(take, notTake);
            dp[index][buy] =  Math.max(max, n);

        } else {

            int take = prices[index] + solve(prices, index + 2, 0, max, dp);

            int notTake = solve(prices, index + 1, 1, max, dp);

            int n = Math.max(take, notTake);

            dp[index][buy] =  Math.max(max, n);

        }

        return dp[index][buy];
    }
}