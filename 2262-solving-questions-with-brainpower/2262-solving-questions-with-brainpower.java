class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return helper(questions, 0, dp);
    }

    private long helper(int[][] questions, int index, long[] dp) {
        if(index >= questions.length) {
            return 0;
        }

        if(index == questions.length - 1) {
            return questions[index][0];
        }

        if(dp[index] != -1){
            return dp[index];
        }

        long pick = questions[index][0] + helper(questions, index + questions[index][1] + 1, dp);
        long notPick = helper(questions, index + 1, dp);

        dp[index]=  Math.max(pick, notPick);
        return dp[index];
    }
}