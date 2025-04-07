class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return helper(nums, 0, 0, target, dp);
    }

    private boolean helper(int[] nums, int index, int currentSum, int target, Boolean[][] dp) {
        if (currentSum == target) return true;
        if (index >= nums.length || currentSum > target) return false;
        if (dp[index][currentSum] != null) return dp[index][currentSum];

        boolean pick = helper(nums, index + 1, currentSum + nums[index], target, dp);
        boolean notPick = helper(nums, index + 1, currentSum, target, dp);

        dp[index][currentSum] = pick || notPick;
        return dp[index][currentSum];
    }
}
