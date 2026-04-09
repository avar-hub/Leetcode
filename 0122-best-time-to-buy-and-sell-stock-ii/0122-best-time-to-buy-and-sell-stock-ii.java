class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++) {
            for(int j = 0 ; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, 1, prices, 0, dp);
    }

    private int solve(int index, int buy, int[] prices, int profit, int[][] dp) {
        if(index == prices.length) return profit;

        if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1) {
            profit = Math.max(solve(index + 1, 0, prices, profit, dp) - prices[index] , solve(index + 1, 1, prices, profit, dp));
        } else {
            profit = Math.max(solve(index + 1, 1, prices, profit, dp) + prices[index] , solve(index + 1, 0, prices, profit, dp));
        }
        return dp[index][buy] = profit;
    }
}