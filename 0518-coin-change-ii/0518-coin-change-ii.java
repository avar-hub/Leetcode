class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length +1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(coins, amount, 0, dp);
    }

    private int helper(int[] coins, int amount, int index, int[][] dp) {
        if(index >= coins.length || amount < 0) {
            return 0;
        }

        if(amount == 0) {
            return 1;
        }

        if(dp[amount][index] != -1) {
            return dp[amount][index];
        }


        int pick = helper(coins, amount - coins[index], index, dp);
        int notPick = helper(coins, amount, index + 1, dp);

        dp[amount][index] =  pick + notPick;

        return dp[amount][index];

    }
}