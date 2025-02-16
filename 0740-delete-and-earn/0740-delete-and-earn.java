class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i : nums) {
            max = Math.max(i, max);
        }

        int[] arr = new int[max + 1];
        int dp[] = new int[max + 1];
        Arrays.fill(dp ,-1);
        for(int i : nums) {
            arr[i] += i;
        }
        return helper(arr, 0, dp);
    }

    public int helper(int[] arr, int index, int[] dp) {
        if(index >= arr.length) {
            return 0;
        }

        if(index == arr.length - 1) {
            return arr[index];
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int pick = arr[index] + helper(arr, index + 2, dp);
        int notPick = helper(arr, index + 1, dp);

        dp[index] =  Math.max(pick, notPick);

        return dp[index];
    }
}