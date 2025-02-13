class Solution {
    public int rob(int[] nums) {
    int dp[] = new int[101];
    Arrays.fill(dp, -1);
       return helper(nums, 0, dp);
       
    }

    public int helper(int[] nums, int index, int[] dp) {
        if(index >= nums.length) {
            return 0;
        }
        if(dp[index] != -1) {
            return dp[index];
        }
        int pick = nums[index] + helper(nums, index + 2, dp);
        int notPick = helper(nums, index + 1, dp);


        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
}