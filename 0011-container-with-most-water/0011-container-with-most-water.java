class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1 , container = 0;
        while(i < j) {
            int water = Math.min(height[i], height[j]) * (j - i);
            container = Math.max(container, water);
            if(height[i] < height[j]) i++;
            else if(height[i] > height[j]) j--;
            else {
                i++;
                j--;
            }
        }
        return container;
    }
}