class Solution {
    public long maximumTripletValue(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        int lMax = 0 , rMax = 0;
        leftMax[0] = 0;
        for(int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(nums[i-1], lMax);
            lMax = leftMax[i];
        }
        rightMax[nums.length - 1] = 0;
        for(int j = nums.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(nums[j + 1], rMax);
            rMax = rightMax[j];
        }

        long ans = 0;
        for(int i = 1; i < nums.length -1 ; i++) {
            ans = Math.max((((long)leftMax[i] - nums[i]) * rightMax[i]), ans);
        }
        return ans;
    }
}