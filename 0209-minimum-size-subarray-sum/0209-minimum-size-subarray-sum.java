class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0, j = 0;

        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i]; 
                i++;
            }
            
            j++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
