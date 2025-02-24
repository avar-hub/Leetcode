class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for(int[] row : dp) {
        Arrays.fill(row, -1);
        }
        return helper(0, -1, nums, dp);
    }

   private int helper(int index, int prev, int[] nums, int[][] dp) {
    if (index >= nums.length) { 
        return 0;
    }

    if(dp[index][prev + 1] != -1) {
        return dp[index][prev + 1];
    }

    int pick = 0;  
    if (prev == -1 || nums[prev] < nums[index]) {
        pick = 1 + helper(index + 1, index, nums, dp);
    }
    
    int notPick = helper(index + 1, prev, nums, dp); 

    dp[index][prev + 1]= Math.max(pick, notPick);

    return dp[index][prev + 1];
}
}