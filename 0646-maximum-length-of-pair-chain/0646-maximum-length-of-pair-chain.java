import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1])); 
        int[][] dp = new int[pairs.length][pairs.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1); 
        }
        return helper(pairs, 0, -1, dp);
    }

    private int helper(int[][] pairs, int index, int lastPairIndex, int[][] dp) {
        if (index >= pairs.length) return 0;

        if (dp[index][lastPairIndex + 1] != -1) {
            return dp[index][lastPairIndex + 1];
        }

        int pick = 0;
        if (lastPairIndex == -1 || pairs[lastPairIndex][1] < pairs[index][0]) {
            pick = 1 + helper(pairs, index + 1, index, dp); 
        }
        int notPick = helper(pairs, index + 1, lastPairIndex, dp); 

        dp[index][lastPairIndex + 1] = Math.max(pick, notPick); 

        return dp[index][lastPairIndex + 1];
    }
}
