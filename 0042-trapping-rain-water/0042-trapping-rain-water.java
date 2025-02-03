class Solution {
    public int trap(int[] height) {
        int[] leftMax =getLeftMax(height);
        int[] rightMax = getRightMax(height);
        int water = 0;
        for(int i = 0; i < height.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            water += min - height[i];
        }

        return water;

    }

    private int[] getLeftMax(int[] height) {
        int[] ans = new int[height.length];
        ans[0] = height[0];

        for(int i = 1; i < height.length; i++) {
            ans[i] = Math.max(ans[i-1], height[i]);
        }
        return ans;
    } 

        private int[] getRightMax(int[] height) {
        int[] ans = new int[height.length];
        ans[ans.length - 1] = height[height.length - 1];

        for(int i = ans.length - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i+1], height[i]);
        }
        return ans;
    } 
}