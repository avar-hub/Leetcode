class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        int totalCandies = 0;
        Arrays.fill(candies, 1);
        // First left neighbour 
        for(int i = 1; i < ratings.length ; i++) {
            if(ratings[i-1] < ratings[i] && candies[i-1] >= candies[i]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        // Then Right Neighbour
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i+1] < ratings[i] && candies[i+1] >= candies[i]) {
                candies[i] = candies[i+1] + 1;
            }
        }
        for(int val : candies) {
            totalCandies += val;
        }
        return totalCandies;
    }
}