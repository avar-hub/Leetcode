class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(word1, word2, 0, 0, dp);
    }

    private int helper(String word1, String word2, int i , int j, int[][] dp) {

        if(j >= word2.length()) {
            return word1.length() - i;
        }

        if(i >= word1.length()) {
            return word2.length() - j;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            return helper(word1, word2, i + 1, j + 1, dp);
        } else {
           int delete = 1 + helper(word1, word2, i+1, j, dp);
           int update = 1 +helper(word1, word2, i+1, j+1, dp);
           int insert = 1 + helper(word1, word2, i, j+1, dp);

           int n = Math.min(delete, update);

           dp[i][j] = Math.min(n, insert);

           return dp[i][j];
        }
    }
}